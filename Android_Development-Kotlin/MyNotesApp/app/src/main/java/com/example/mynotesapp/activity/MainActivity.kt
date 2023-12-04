package com.example.mynotesapp.activity

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.mynotesapp.databinding.ActivityMainBinding
import com.example.mynotesapp.utility.SharedPrefsHelper

class MainActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var binding: ActivityMainBinding

    private var sensorManager: SensorManager? = null
    private var sensor: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SharedPrefsHelper.init(this)
        setDataBinding()

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    }

    override fun onResume() {
        super.onResume()
        setDataBinding()
        sensorManager?.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)

    }

    private fun setDataBinding() {
        val currentNote = SharedPrefsHelper.getCurrentNote() as String
        binding.saveNoteBtn.isEnabled = false

        binding.inputNoteField.addTextChangedListener {
            val noteInput = binding.inputNoteField.text.toString()

            if (!noteInput.isEmpty()) {
                binding.saveNoteBtn.isEnabled = true
            }
        }

        binding.inputNoteField.addTextChangedListener {
            val noteInput = binding.inputNoteField.text.toString()

            if (noteInput == currentNote) {
                binding.saveNoteBtn.isEnabled = false
            }
        }

        if (currentNote.isEmpty() || currentNote == "There is no saved note!") {
            binding.showSavedNoteBtn.isEnabled = false
        }

        binding.saveNoteBtn.setOnClickListener {
            val noteInput = binding.inputNoteField.text.toString()

            if (noteInput.isEmpty()) {
                binding.inputNoteField.error = "The note field cannot be empty"
                return@setOnClickListener
            }

            SharedPrefsHelper.removeNote()
            SharedPrefsHelper.saveNote(noteInput)

            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            finish();
            startActivity(intent);
        }

        binding.showSavedNoteBtn.setOnClickListener {
            binding.inputNoteField.setText("")
            binding.inputNoteField.setText(currentNote)

            return@setOnClickListener
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        val yReading = event?.values?.get(1) // tilt value on the Y-axis

        if (yReading != null) {
            if (yReading < 6.9) {
                binding.inputNoteField.setText("")
                val noteInput = binding.inputNoteField.text.toString()

                binding.inputNoteField.addTextChangedListener {
                    if (noteInput.isEmpty()) {
                        binding.saveNoteBtn.isEnabled = false
                    }
                }
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }
}
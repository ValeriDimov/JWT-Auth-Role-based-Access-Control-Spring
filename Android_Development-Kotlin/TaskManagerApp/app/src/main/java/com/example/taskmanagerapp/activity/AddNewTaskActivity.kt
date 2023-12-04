package com.example.taskmanagerapp.activity

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taskmanagerapp.databinding.ActivityAddNewTaskBinding
import com.example.taskmanagerapp.utility.SharedPrefsHelper

class AddNewTaskActivity : AppCompatActivity(), SensorEventListener {
    private lateinit var binding: ActivityAddNewTaskBinding

    private var sensorManager: SensorManager? = null
    private var sensor: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddNewTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SharedPrefsHelper.init(this)
        setAddNewTaskDataBinging()

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

    }

    private fun setAddNewTaskDataBinging() {
        binding.saveTaskBtn.setOnClickListener {
            val taskName = binding.addingNameField.text.toString()
            val taskDesc = binding.addingDescriptionField.text.toString()

            if (taskName.isEmpty()) {
                binding.addingNameField.error = "The name cannot be empty"
                return@setOnClickListener
            }

            if (SharedPrefsHelper.taskExists(taskName)) {
                binding.addingNameField.error = "Task with same name already exists"
                return@setOnClickListener
            }

            SharedPrefsHelper.saveTask(taskName, taskDesc)

            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        sensorManager?.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL )
    }

    override fun onSensorChanged(event: SensorEvent?) {
        val xReading = event?.values?.get(0) // tilt value on the X-axis
        val yReading = event?.values?.get(1) // tilt value on the Y-axis
        val zReading = event?.values?.get(2) // tilt value on the Z-axis

        if (yReading != null) {
            if (yReading < 6.9) {
                binding.addingNameField.setText("")
                binding.addingDescriptionField.setText("")
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }
}
package com.example.taskmanagerapp.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taskmanagerapp.databinding.ActivityMainBinding
import com.example.taskmanagerapp.utility.Constants
import com.example.taskmanagerapp.utility.SharedPrefsHelper
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SharedPrefsHelper.init(this)
        setDataBinding()
        showSavedTasks()
    }

    override fun onResume() {
        super.onResume()
        showSavedTasks()
    }

    private fun setDataBinding() {
        binding.tasksList

        binding.addTaskBtn.setOnClickListener {
            val intent = Intent(this, AddNewTaskActivity::class.java)
            startActivity(intent)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showSavedTasks() {
        binding.tasksList.removeAllViews()

        val allTasks = SharedPrefsHelper.getAllTasks()
        val allTasksNames = allTasks.map { it.key }

        if (allTasksNames.isEmpty()) {
            val textView = MaterialTextView(this)
            textView.text = "Currently there are no saved tasks!"
            binding.tasksList.addView(textView)
            return
        }

        allTasks.forEach {
            val taskName = it.key
            val taskDesc = it.value

            val textView = MaterialTextView(this)
            textView.text = it.key
            binding.tasksList.addView(textView)

            textView.setOnClickListener {
                val intent = Intent(this, ReviewTaskActivity::class.java)
                intent.putExtra(Constants.KEY_REVIEW_TASK_NAME, taskName)
                intent.putExtra(Constants.KEY_REVIEW_TASK_DESC, taskDesc as String)

                startActivity(intent)
            }

        }
    }


}

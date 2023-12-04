package com.example.taskmanagerapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taskmanagerapp.databinding.ActivityReviewTaskBinding
import com.example.taskmanagerapp.utility.Constants
import com.example.taskmanagerapp.utility.SharedPrefsHelper

class ReviewTaskActivity: AppCompatActivity() {

    private lateinit var binding: ActivityReviewTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityReviewTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SharedPrefsHelper.init(this)
        setDataBinding()
    }

    private fun setDataBinding() {
        val taskName = intent.getStringExtra(Constants.KEY_REVIEW_TASK_NAME)
        val taskDesc = intent.getStringExtra(Constants.KEY_REVIEW_TASK_DESC)

        binding.taskName = taskName
        binding.taskDesc = taskDesc

        binding.completeTaskBtn.setOnClickListener {
            SharedPrefsHelper.taskComplete(taskName as String)

            finish()
        }
    }
}
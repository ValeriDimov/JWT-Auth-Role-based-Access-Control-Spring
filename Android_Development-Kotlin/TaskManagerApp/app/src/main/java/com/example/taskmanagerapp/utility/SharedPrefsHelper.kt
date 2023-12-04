package com.example.taskmanagerapp.utility

import android.content.Context
import android.content.SharedPreferences

object SharedPrefsHelper {

    private const val KEY_SHARED_PREFS_NAME = "KEY_SHARED_PREFS_NAME"
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences =
            context.getSharedPreferences(KEY_SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun taskExists(name: String): Boolean {
        return sharedPreferences.contains(name)
    }

    fun saveTask(name: String, description: String) {
        val editor = sharedPreferences.edit()
        editor.putString(name, description)
        editor.apply()
    }

    fun taskComplete(name: String) {
        val editor = sharedPreferences.edit()
        editor.remove(name)
        editor.apply()
    }

    fun getAllTasks(): Map<String, *> {
        return sharedPreferences
            .all.toSortedMap()
    }

}
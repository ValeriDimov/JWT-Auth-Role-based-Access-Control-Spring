package com.example.mynotesapp.utility

import android.content.Context
import android.content.SharedPreferences

object SharedPrefsHelper {

    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences =
            context.getSharedPreferences(Constants.KEY_SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun saveNote(noteDescription: String) {
        val editor = sharedPreferences.edit()
        editor.putString(Constants.KEY_NOTE_STATUS_NEW, noteDescription)
        editor.apply()
    }

    fun removeNote() {
        val editor = sharedPreferences.edit()
        editor.remove(Constants.KEY_NOTE_STATUS_NEW)
        editor.apply()
    }

    fun getCurrentNote(): String? {
       return sharedPreferences
           .getString(Constants.KEY_NOTE_STATUS_NEW, "There is no saved note!" )
    }
}
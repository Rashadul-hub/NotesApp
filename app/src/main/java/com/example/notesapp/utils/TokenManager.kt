package com.example.notesapp.utils

import android.content.Context
import com.example.notesapp.utils.Constants.PREFERENCE_TOKEN_FILE
import com.example.notesapp.utils.Constants.USER_TOKEN
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TokenManager @Inject constructor(@ApplicationContext context: Context) {

    private var preference = context.getSharedPreferences(PREFERENCE_TOKEN_FILE, Context.MODE_PRIVATE)

    fun saveToken(token:String){
        val editor = preference.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    fun getToken(): String? {
        return preference.getString(USER_TOKEN, null)
    }
}
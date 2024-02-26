package com.example.messmeapp.backend.preferences

import android.content.Context

object PrefUtils {



    fun clearPreferences(context: Context) {
        val prefs = context.getSharedPreferences(AppPreference.MESSME_APP, Context.MODE_PRIVATE)
        prefs.edit().clear().apply()
    }

    fun setString(context: Context, key: String, value: String) {
        val prefs = context.getSharedPreferences(AppPreference.MESSME_APP, Context.MODE_PRIVATE)
        prefs.edit().putString(key, value).apply()
    }

    fun getString(context: Context, key: String): String? {
        val prefs = context.getSharedPreferences(AppPreference.MESSME_APP, Context.MODE_PRIVATE)
        return prefs.getString(key, null)
    }

    fun setBoolean(context: Context, key: String, value: Boolean) {
        val prefs = context.getSharedPreferences(AppPreference.MESSME_APP, Context.MODE_PRIVATE)
        prefs.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(context: Context, key: String,  value: Boolean): Boolean {
        val prefs = context.getSharedPreferences(AppPreference.MESSME_APP, Context.MODE_PRIVATE)
        return prefs.getBoolean(key, value)
    }
}
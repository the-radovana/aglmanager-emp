package com.example.aglmanager

import android.content.Context
import android.content.SharedPreferences
import com.example.aglmanager.data.User

object SharedPreferencesManager {
    private const val PREFS_NAME = "AGLManagerPrefs"
    private const val KEY_USER = "user"
    private const val KEY_ACCESS_TOKEN = "accessToken"
    private const val KEY_REFRESH_TOKEN = "refreshToken"
    private const val KEY_ACCESS_TOKEN_EXP = "accessTokenExp"
    private const val KEY_REFRESH_TOKEN_EXP = "refreshTokenExp"
    private const val KEY_IS_LOGGED_IN = "isLoggedIn"

    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun saveLoginData(accessToken: String, refreshToken: String, accessTokenExp: String, refreshTokenExp: String) {
        preferences.edit().apply {
            putString(KEY_ACCESS_TOKEN, accessToken)
            putString(KEY_REFRESH_TOKEN, refreshToken)
            putString(KEY_ACCESS_TOKEN_EXP, accessTokenExp)
            putString(KEY_REFRESH_TOKEN_EXP, refreshTokenExp)
            putBoolean(KEY_IS_LOGGED_IN, true)
            apply()
        }
    }

    fun clearLoginData() {
        preferences.edit().clear().apply()
    }
    fun getAccessToken(): String? = preferences.getString(KEY_ACCESS_TOKEN, null)
    fun getRefreshToken(): String? = preferences.getString(KEY_REFRESH_TOKEN, null)
    fun getAccessTokenExp(): String? = preferences.getString(KEY_ACCESS_TOKEN_EXP, null)
    fun getRefreshTokenExp(): String? = preferences.getString(KEY_REFRESH_TOKEN_EXP, null)
    fun isLoggedIn(): Boolean = preferences.getBoolean(KEY_IS_LOGGED_IN, false)
}
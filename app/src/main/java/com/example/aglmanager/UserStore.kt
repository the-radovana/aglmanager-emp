package com.example.aglmanager

import com.example.aglmanager.data.User
import kotlinx.coroutines.flow.MutableStateFlow

object UserStore {
    var user: User? = null
    var accessToken: String? = ""
    var refreshToken: String? = ""
    var accessTokenExp: String? = ""
    var refreshTokenExp: String? = ""
    private val _isLoggedIn = MutableStateFlow(false)

    fun setLoggedIn(loggedIn: Boolean) {
        _isLoggedIn.value = loggedIn
    }

    fun getIsLoggedIn(): Boolean {
        return _isLoggedIn.value
    }

    fun loadFromPreferences() {
        if (SharedPreferencesManager.isLoggedIn()) {
            accessToken = SharedPreferencesManager.getAccessToken()
            refreshToken = SharedPreferencesManager.getRefreshToken()
            accessTokenExp = SharedPreferencesManager.getAccessTokenExp()
            refreshTokenExp = SharedPreferencesManager.getRefreshTokenExp()
            setLoggedIn(true)
        }
    }

    fun saveToPreferences() {
        user?.let {
            SharedPreferencesManager.saveLoginData(
                accessToken ?: "",
                refreshToken ?: "",
                accessTokenExp ?: "",
                refreshTokenExp ?: ""
            )
        }
    }

    fun clearPreferences() {
        SharedPreferencesManager.clearLoginData()
    }
}
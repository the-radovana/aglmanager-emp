package com.example.aglmanager

import com.example.aglmanager.data.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object UserStore {
    var user: User? = null
    var accessToken: String? = ""
    var refreshToken: String? = ""
    var accessTokenExp: String? = ""
    var refreshTokenExp: String? = ""
    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> get() = _isLoggedIn

    fun setLoggedIn(loggedIn: Boolean) {
        _isLoggedIn.value = loggedIn
    }

    fun getIsLoggedIn(): Boolean {
        return _isLoggedIn.value
    }
}
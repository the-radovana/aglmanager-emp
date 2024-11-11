package com.example.aglmanager

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object UserStore {
    private var _username by mutableStateOf<String?>(null)

    fun login(username: String) {
        _username = username
    }

    fun logout() {
        _username = null
    }

    fun getUsername(): String {
        return _username ?: "Guest"
    }

    fun isLoggedIn(): Boolean {
        return _username != null
    }
}
package com.example.aglmanager

import com.example.aglmanager.data.User

object UserStore {
    var user: User? = null
    var accessToken: String? = ""
    var refreshToken: String? = ""
    var accessTokenExp: String? = ""
    var refreshTokenExp: String? = ""
    var isLoggedIn: Boolean = false
}
package com.example.aglmanager.data

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val role: String,
    val createdAt: String,
    val verifiedAt: String? = null
)

@Serializable
data class LoginRequest(
    val email: String,
    val password: String
)

@Serializable
data class Login(
    val message: String,
    val data: Data
)

@Serializable
data class Data(
    val user: User,
    val accessToken: String,
    val accessTokenExp: String,
    val refreshToken: String,
    val refreshTokenExp: String
)

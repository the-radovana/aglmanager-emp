package com.example.aglmanager.ui

import com.example.aglmanager.data.Data

data class AGLManagerUIState(
    val message: String = "Events",
    val authenticatedUser: Data? = null,
)
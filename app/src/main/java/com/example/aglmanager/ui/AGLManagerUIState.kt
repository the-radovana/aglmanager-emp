package com.example.aglmanager.ui

import com.example.aglmanager.data.JsonPlaceholder

data class AGLManagerUIState(
    val message: String = "Events",
    val todo: JsonPlaceholder = JsonPlaceholder(1, 1, "test", false)
)
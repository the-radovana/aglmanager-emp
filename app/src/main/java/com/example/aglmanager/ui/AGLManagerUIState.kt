package com.example.aglmanager.ui

import com.example.aglmanager.data.Data
import com.example.aglmanager.data.EventDetails
import com.example.aglmanager.data.EventList

data class AGLManagerUIState(
    val message: String = "Events",
    val authenticatedUser: Data? = null,
    val events: List<EventList> = emptyList(),
    val selectedEvent: EventDetails? = null
)
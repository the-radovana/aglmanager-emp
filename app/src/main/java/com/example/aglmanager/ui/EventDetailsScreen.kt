package com.example.aglmanager.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun EventDetailsScreen(
    eventId: Int,
    viewModel: AGLManagerViewModel = viewModel(),
    navController: NavController
) {
    val uiState by viewModel.uiState.collectAsState()

    // Fetch event details when the screen is displayed
    LaunchedEffect(eventId) {
        viewModel.getEventDetails(eventId)
    }

    val event = uiState.selectedEvent

    event?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = it.title, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = it.description, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Start Time: ${it.startTime}", style = MaterialTheme.typography.bodySmall)
            Text(text = "End Time: ${it.endTime}", style = MaterialTheme.typography.bodySmall)
            // Add more fields as needed
        }
    }
}
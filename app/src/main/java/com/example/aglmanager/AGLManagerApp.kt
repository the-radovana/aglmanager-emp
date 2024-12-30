package com.example.aglmanager

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aglmanager.ui.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.aglmanager.ui.components.AGLBottomNavBar

enum class AGLManagerScreen(val title: String) {
    Events("Events"),
    CreateEvent("Create Event"),
    Profile("Profile"),
    Login("Login"),
    EventDetails("Event Details")
}

@Composable
fun AGLManagerApp(
    viewModel: AGLManagerViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = {
            if (UserStore.isLoggedIn) {
                AGLBottomNavBar(navController = navController)
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = if (UserStore.isLoggedIn)
                AGLManagerScreen.Events.name
            else
                AGLManagerScreen.Login.name,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = AGLManagerScreen.Events.name) {
                HomeScreen(viewModel = viewModel, navController = navController)
            }
            composable(route = AGLManagerScreen.Login.name) {
                LoginScreen(viewModel = viewModel, navController = navController)
            }
            composable(route = AGLManagerScreen.CreateEvent.name) {
                CreateEventScreen(viewModel = viewModel, navController = navController)
            }
            composable(route = AGLManagerScreen.Profile.name) {
                ProfileScreen(viewModel = viewModel, navController = navController)
            }
            composable(route = "${AGLManagerScreen.EventDetails.name}/{eventId}") { backStackEntry ->
                val eventId = backStackEntry.arguments?.getString("eventId")?.toInt() ?: 0
                EventDetailsScreen(eventId = eventId, viewModel = viewModel, navController = navController)
            }
        }
    }
}
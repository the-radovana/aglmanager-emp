package com.example.aglmanager.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.aglmanager.AGLManagerScreen

@Composable
fun AGLBottomNavBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ){
        NavigationBar {
            NavigationBarItem(
                icon = { Icon(Icons.Filled.CalendarMonth, contentDescription = "Home") },
                label = { Text(AGLManagerScreen.Events.title) },
                selected = currentRoute == AGLManagerScreen.Events.name,
                onClick = { navController.navigate(AGLManagerScreen.Events.name) }
            )
            NavigationBarItem(
                icon = { },
                label = { },
                selected = false,
                onClick = { }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
                label = { Text(AGLManagerScreen.Profile.title) },
                selected = currentRoute == AGLManagerScreen.Profile.name,
                onClick = { navController.navigate(AGLManagerScreen.Profile.name) }
            )
        }

        FloatingActionButton(
            onClick = { navController.navigate(AGLManagerScreen.CreateEvent.name) },
            modifier = Modifier
                .offset(y = (-60).dp)
                .size(64.dp),
            shape = CircleShape,
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            elevation = FloatingActionButtonDefaults.elevation(
                defaultElevation = 6.dp,
                pressedElevation = 12.dp
            )
        ) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Create Event",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
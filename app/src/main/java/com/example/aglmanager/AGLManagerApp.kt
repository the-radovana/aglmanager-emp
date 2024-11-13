package com.example.aglmanager

import AGLManagerViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aglmanager.ui.LoginScreen
import com.example.aglmanager.ui.HomeScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController


enum class AGLManagerScreen() {
    Home,
    Login,
}

@Composable
fun AGLManagerApp(viewModel: AGLManagerViewModel = viewModel(),
                   navController: NavHostController = rememberNavController()) {

    NavHost(navController = navController,
        startDestination = AGLManagerScreen.Login.name
    ) {
        composable(route = AGLManagerScreen.Home.name) {
            HomeScreen(viewModel = viewModel, navController = navController)
        }
        composable(route = AGLManagerScreen.Login.name) {
            LoginScreen(viewModel = viewModel, navController = navController)
        }
    }
}
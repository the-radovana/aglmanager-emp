package com.example.aglmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.aglmanager.ui.theme.AGLManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AGLManagerTheme {
                AGLManagerApp()
            }
        }
    }
}

/*import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aglmanager.ui.LoginScreen*/


/*class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AGLManagerTheme {
                var showLogin by remember { mutableStateOf(false) }

                if (showLogin) {
                    LoginScreen(onNavigateBack = { showLogin = false })
                } else {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        Column(
                            modifier = Modifier
                                .padding(innerPadding)
                                .padding(16.dp)
                        ) {
                            Greeting()
                            Spacer(modifier = Modifier.height(16.dp))
                            if(UserStore.isLoggedIn()) {
                                Button(
                                    onClick = { UserStore.logout() },
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text("Logout")
                                }
                            } else {
                                Button(
                                    onClick = { showLogin = true },
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text("Login")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}*/






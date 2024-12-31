package com.example.aglmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.aglmanager.ui.theme.AGLManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SharedPreferencesManager.init(this)
        UserStore.loadFromPreferences()
        enableEdgeToEdge()
        setContent {
            AGLManagerTheme {
                AGLManagerApp()
            }
        }
    }
}

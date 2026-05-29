package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.ui.MainViewModel
import com.example.ui.MainViewModelFactory
import com.example.ui.screens.AuthScreen
import com.example.ui.screens.MainHubScreen
import com.example.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        enableEdgeToEdge()

        val factory = MainViewModelFactory(application)
        val viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val currentScreen by viewModel.currentScreen.collectAsState()

                    Crossfade(
                        targetState = currentScreen,
                        label = "ScreenCrossfade"
                    ) { screen ->
                        when (screen) {
                            MainViewModel.Screen.LOGIN, MainViewModel.Screen.REGISTER -> {
                                AuthScreen(viewModel = viewModel)
                            }
                            MainViewModel.Screen.MAIN_HUB -> {
                                MainHubScreen(viewModel = viewModel)
                            }
                        }
                    }
                }
            }
        }
    }
}

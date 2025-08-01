package com.alex.weber

import Home
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.alex.weber.ui.Components.BotSheet
import com.alex.weber.ui.theme.WeberTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeberTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    //topBar = { TopAppBar() },
                ) { innerPadding ->
//                    TopAppBar()
                    BotSheet(innerPadding)
                }
            }

        }
    }
}





































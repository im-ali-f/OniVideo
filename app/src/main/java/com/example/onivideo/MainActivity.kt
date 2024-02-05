package com.example.onivideo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.onivideo.ui.theme.OniVideoTheme
import com.example.onivideo.ui.theme.mainBGC

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //nav
           val navState= rememberNavController()
            NavHost(navController = navState, startDestination = "mainPage"){
                composable(route="mainPage"){
                    val access= mapOf<String,Boolean>(
                        "menu" to true,
                        "search" to true
                    )

                    Column(modifier = Modifier.fillMaxSize().background(mainBGC), verticalArrangement = Arrangement.SpaceBetween) {
                        NavbarComp(navController = navState,title="Home",access )
                        MainComp(navController = navState)
                        BottombarComp(navController = navState)
                    }

                }
            }
        }
    }
}


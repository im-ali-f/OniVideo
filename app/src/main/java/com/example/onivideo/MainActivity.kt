package com.example.onivideo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

            val navState = rememberNavController()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(mainBGC),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                var access by remember {
                    mutableStateOf(mapOf<String, Boolean>("menu" to true, "search" to true))
                }
                var title by remember {
                    mutableStateOf("Home")
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.9f),
                ) {
                    NavbarComp(navController = navState, title = title, accessMap = access)

                    // nav
                    NavHost(
                        navController = navState,
                        startDestination = "settingPage",
                        //popEnterTransition ={ fadeIn(animationSpec = tween(8700)) } ,
                        //popExitTransition = { fadeOut(animationSpec = tween(8700)) }
                        ) {

                        composable(route = "mainPage") {
                            access = mapOf<String, Boolean>(
                                "bar" to true, "menu" to true, "search" to true
                            )
                            title = "Home"
                            MainComp(navController = navState)
                        }


                        composable(route = "watchlistPage") {
                            access = mapOf<String, Boolean>(
                                "bar" to true, "menu" to true, "search" to true
                            )
                            title = "My Watchlist"
                            WatchListComp(navController = navState)
                        }

                        composable(route = "accountPage") {
                            access = mapOf<String, Boolean>(
                                "bar" to false, "menu" to false, "search" to false
                            )
                            title = "account"
                            AccountComp(navController = navState)
                        }
                        composable(route = "settingPage") {
                            access = mapOf<String, Boolean>(
                                "bar" to true, "menu" to true, "search" to true
                            )
                            title = "Settings"
                            SettingComp(navController = navState)
                        }
                    }


                }


                BottombarComp(navController = navState)
            }


        }
    }
}


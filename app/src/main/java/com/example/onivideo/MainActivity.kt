package com.example.onivideo

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Size
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.onivideo.ui.theme.OniVideoTheme
import com.example.onivideo.ui.theme.mainBGC
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {

            val navState = rememberNavController()
            var bottomBar by remember {
                mutableStateOf(true)
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(mainBGC),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                var access by remember {
                    mutableStateOf(mapOf<String, Boolean>("bar" to true, "menu" to true, "search" to true,"back" to false))
                }
                var title by remember {
                    mutableStateOf("Home")
                }
                val scaffoldState = rememberScaffoldState()
                val scope= rememberCoroutineScope()


                val screenWidth = LocalConfiguration.current.screenWidthDp
                val screenHeight = LocalConfiguration.current.screenHeightDp

                //width
                val width = if(screenWidth<400)460f else 700f
                //height
                val height = if(screenWidth<400)1200f else 2300f
                fun customShape() =  object : Shape {
                    override fun createOutline(
                        size: androidx.compose.ui.geometry.Size,
                        layoutDirection: LayoutDirection,
                        density: Density
                    ): Outline {
                        return Outline.Rectangle(Rect(0f,0f,width /* width */,height /* height */))
                    }
                }

                var active = remember {
                    mutableStateOf("Home")
                }

                androidx.compose.material.Scaffold(
                    modifier = Modifier.background(mainBGC),
                    scaffoldState=scaffoldState,
                    topBar = {
                        NavbarComp(navController = navState, title = title, accessMap = access, active = active, onNavigationIconClick ={
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }

                        } )
                    },
                    bottomBar = {
                        if(bottomBar){
                            BottombarComp(navController = navState, active)
                        }
                    },
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(navController = navState,scaffoldState=scaffoldState,scope, active = active)
                    },
                    drawerBackgroundColor = mainBGC,
                    drawerShape = customShape()
                    ) {
                    var height =if(bottomBar)0.9f else 1f
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(height),
                    ) {

                        // nav
                        NavHost(
                            navController = navState,
                            startDestination = "mainPage",
                            //popEnterTransition ={ fadeIn(animationSpec = tween(8700)) } ,
                            //popExitTransition = { fadeOut(animationSpec = tween(8700)) }
                        ) {

                            composable(route = "mainPage") {
                                access = mapOf<String, Boolean>(
                                    "bar" to true, "menu" to true, "search" to true,"back" to false
                                )
                                title = "Home"
                                bottomBar=true
                                active.value = "Home"
                                MainComp(navController = navState)
                            }


                            composable(route = "watchlistPage") {
                                access = mapOf<String, Boolean>(
                                    "bar" to true, "menu" to true, "search" to true,"back" to false
                                )
                                title = "My Watchlist"
                                bottomBar=true
                                active.value = "Watchlist"
                                WatchListComp(navController = navState)
                            }

                            composable(route = "accountPage") {
                                access = mapOf<String, Boolean>(
                                    "bar" to false, "menu" to false, "search" to false,"back" to false
                                )
                                title = "account"
                                bottomBar=true
                                active.value = "Account"
                                AccountComp(navController = navState)
                            }
                            composable(route = "settingPage") {
                                access = mapOf<String, Boolean>(
                                    "bar" to true, "menu" to true, "search" to true,"back" to false
                                )
                                title = "Settings"
                                bottomBar=true
                                active.value = "Settings"
                                SettingComp(navController = navState)
                            }

                            composable(route = "dashboardPage") {
                                access = mapOf<String, Boolean>(
                                    "bar" to true, "menu" to false, "search" to false,"back" to true
                                )
                                title = "Dashboard"
                                bottomBar=false
                                DashboardComp(navController = navState)
                            }

                            composable(route = "loginSignupPage") {
                                access = mapOf<String, Boolean>(
                                    "bar" to false, "menu" to false, "search" to false,"back" to false
                                )
                                title = "login sign up"
                                bottomBar=false
                                LoginSignupComp(navController = navState)
                            }

                            composable(route = "TVShowsPage") {
                                access = mapOf<String, Boolean>(
                                    "bar" to true, "menu" to true, "search" to true,"back" to false
                                )
                                title = "TV Shows"
                                bottomBar=true
                                active.value = "TV Shows"
                                TVShowsComp(navController = navState)
                            }

                            composable(route = "moviesPage") {
                                access = mapOf<String, Boolean>(
                                    "bar" to true, "menu" to true, "search" to true,"back" to false
                                )
                                title = "Movies"
                                bottomBar=true
                                active.value = "Movies"
                                MoviesComp(navController = navState)
                            }

                            composable(route = "sportsPage") {
                                access = mapOf<String, Boolean>(
                                    "bar" to true, "menu" to true, "search" to true,"back" to false
                                )
                                title = "Sports"
                                bottomBar=true
                                active.value = "Sports"
                                SportsComp(navController = navState)
                            }


                            composable(route = "liveTVPage") {
                                access = mapOf<String, Boolean>(
                                    "bar" to true, "menu" to true, "search" to true,"back" to false
                                )
                                title = "Live TV"
                                bottomBar=true
                                active.value = "Live TV"
                                LiveTVComp(navController = navState)
                            }

                            composable(route = "searchPage") {
                                access = mapOf<String, Boolean>(
                                    "bar" to true, "menu" to false, "search" to false,"back" to true
                                )
                                title = "Search"
                                bottomBar=false
                                SearchComp(navController = navState)
                            }

                            composable(route = "specificMoviePage") {
                                access = mapOf<String, Boolean>(
                                    "bar" to false, "menu" to false, "search" to false,"back" to false
                                )
                                title = "movie"
                                bottomBar=false
                                SpecificMovieComp(navController = navState)
                            }


                        }


                    }





                }




            }


        }
    }
}




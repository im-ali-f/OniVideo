package com.example.onivideo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material.icons.twotone.AccountCircle
import androidx.compose.material.icons.twotone.Home
import androidx.compose.material.icons.twotone.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.convertTo
import androidx.navigation.NavController
import com.example.onivideo.ui.theme.bottombarBGC
import com.example.onivideo.ui.theme.bottombarContent
import com.example.onivideo.ui.theme.bottombarContentSelected

@Composable
fun BottombarComp(navController: NavController){

    BottomAppBar(modifier = Modifier
        .fillMaxWidth()
        .height(70.dp), containerColor = bottombarBGC, contentColor = bottombarContent,
    ) {


        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){

            // color for chosen menu
            var btn1Color by remember {
                mutableStateOf(bottombarContentSelected)
            }
            var btn2Color by remember {
                mutableStateOf(bottombarContent)
            }
            var btn3Color by remember {
                mutableStateOf(bottombarContent)
            }
            var btn4Color by remember {
                mutableStateOf(bottombarContent)
            }

            IconButton(onClick = {
                btn4Color= bottombarContent
                btn1Color= bottombarContentSelected
                btn2Color= bottombarContent
                btn3Color= bottombarContent
                /*ToDo inja bayad navigate she*/
                navController.navigate("mainPage")
                                 },
                Modifier
                    .fillMaxHeight()
                    .width(80.dp)) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.TwoTone.Home,
                        contentDescription = null,
                        Modifier.size(30.dp),
                        tint = btn1Color
                    )
                    Text(text = "Home", fontSize = 15.sp, color = btn1Color)
                }

            }



            IconButton(onClick = {
                btn4Color= bottombarContent
                btn1Color= bottombarContent
                btn2Color= bottombarContentSelected
                btn3Color= bottombarContent
                /*ToDo inja bayad navigate she*/
                navController.navigate("mainPage2")
                                 },
                Modifier
                    .fillMaxHeight()
                    .width(80.dp)) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painterResource(id =R.drawable.list),
                        contentDescription = null,
                        Modifier.size(30.dp),
                        tint = btn2Color
                    )
                    Text(text = "Watchlist", fontSize = 15.sp, color = btn2Color)
                }

            }


            IconButton(onClick = {
                btn4Color= bottombarContent
                btn1Color= bottombarContent
                btn2Color= bottombarContent
                btn3Color= bottombarContentSelected
                /*ToDo inja bayad navigate she*/ },
                Modifier
                    .fillMaxHeight()
                    .width(80.dp)) {
                Column (horizontalAlignment = Alignment.CenterHorizontally){
                    Icon(
                        imageVector = Icons.TwoTone.AccountCircle,
                        contentDescription = null,
                        Modifier.size(30.dp),
                        tint = btn3Color
                    )
                    Text(text = "Account", fontSize = 15.sp, color = btn3Color)
                }

            }


            IconButton(onClick = {
                btn4Color= bottombarContentSelected
                btn1Color= bottombarContent
                btn2Color= bottombarContent
                btn3Color= bottombarContent
                                 /*ToDo inja bayad navigate she*/},
                Modifier
                    .fillMaxHeight()
                    .width(80.dp)) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.TwoTone.Settings,
                        contentDescription = null,
                        Modifier.size(30.dp),
                        tint = btn4Color
                    )
                    Text(text = "Settings", fontSize = 15.sp, color = btn4Color)
                }

            }
        }



    }
}
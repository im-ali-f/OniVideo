package com.example.onivideo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.onivideo.ui.theme.brush1
import com.example.onivideo.ui.theme.brush2
import com.example.onivideo.ui.theme.mainBGC
import com.example.onivideo.ui.theme.mainFontColor
import com.example.onivideo.ui.theme.moviePlayUnderColor
import com.example.onivideo.ui.theme.navBrush1
import com.example.onivideo.ui.theme.navBrush2

@Composable
fun SpecificMovieComp(navController: NavController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(mainBGC)
    ) {

        //sec 1
        Box(modifier = Modifier.fillMaxWidth()) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(brush1, brush2)
                        )
                    ), contentAlignment = Alignment.Center
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize().background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black)
                    )
                )){
                    Box(modifier = Modifier
                        .size(75.dp)
                        .clip(RoundedCornerShape(100))
                        .background(
                            moviePlayUnderColor
                        ))
                    Box(modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(100))
                        .clickable { }
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(navBrush1, navBrush2)
                            )
                        ), contentAlignment = Alignment.Center
                    ){
                        Icon(modifier = Modifier.fillMaxSize(),imageVector = Icons.Rounded.PlayArrow, contentDescription = null, tint = Color.White )
                    }
                }

            }
            IconButton(modifier = Modifier.align(Alignment.TopStart),onClick = {
                navController.popBackStack()}) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )

            }


        }

        //sec 2


    }
}
package com.example.onivideo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onivideo.ui.theme.mainBGC
import com.example.onivideo.ui.theme.mainFontColor
import com.example.onivideo.ui.theme.navBrush1
import com.example.onivideo.ui.theme.navBrush2
import com.example.onivideo.ui.theme.sec1BGCColor
import com.example.onivideo.ui.theme.sec1UnselectedColor
import com.example.onivideo.ui.theme.sec2BGCColor
import com.example.onivideo.ui.theme.sec2English
import com.example.onivideo.ui.theme.sec2Hindi
import com.example.onivideo.ui.theme.sec2Persian
import com.example.onivideo.ui.theme.sec2SelectedUnder
import com.example.onivideo.ui.theme.sec2Spanish

@Composable
fun TVShowsComp(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(mainBGC)
            .padding(10.dp)
    ) {
        //sec1
        val selected = Brush.horizontalGradient(
            colors = listOf(navBrush1, navBrush2)
        )
        val unselected = Brush.horizontalGradient(
            colors = listOf(sec1UnselectedColor, sec1UnselectedColor)
        )

        var language by remember {
            mutableStateOf(true)
        }
        var genre by remember {
            mutableStateOf(false)
        }
        if (language) genre = false
        else genre = true

        var languageColor = if (language) selected else unselected
        var genreColor = if (genre) selected else unselected

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(100))
                .background(sec1BGCColor)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    language = true
                    genre = false
                },
                modifier = Modifier
                    .fillMaxWidth(0.47f)
                    .clip(shape = RoundedCornerShape(100))
                    .background(
                        languageColor
                    )
                    .height(40.dp),
                shape = RoundedCornerShape(100),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Language", textAlign = TextAlign.Center,
                    color = mainFontColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600)
                )
            }


            Button(
                onClick = {
                    genre = true
                    language = false
                },
                modifier = Modifier
                    .fillMaxWidth(0.93f)
                    .clip(shape = RoundedCornerShape(100))
                    .background(
                        genreColor
                    )
                    .height(40.dp),
                shape = RoundedCornerShape(100),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Genre", textAlign = TextAlign.Center,
                    color = mainFontColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600)
                )
            }


        }
        //sec2
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )
        var scrollState = rememberScrollState()
        Row(
            Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(6.dp))
                .background(sec2BGCColor)
                .padding(10.dp, 10.dp, 0.dp, 10.dp)
                .horizontalScroll(scrollState),// in bayad verical bemone ?
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            if (language) {
                var selected by remember {
                    mutableStateOf("Hindi")
                }

                //hindi
                Box(contentAlignment = Alignment.Center) {
                    Box(modifier = Modifier
                        .width(135.dp)
                        .height(49.dp)
                        .clip(RoundedCornerShape(100))
                        .clickable { selected = "Hindi" }
                        .background(
                            if (selected == "Hindi") sec2SelectedUnder else Color.Transparent
                        ))
                    Box(
                        modifier = Modifier
                            .width(127.dp)
                            .height(41.dp)
                            .clip(RoundedCornerShape(100))
                            .background(
                                sec2Hindi
                            ), contentAlignment = Alignment.Center
                    )
                    {
                        Text(
                            text = "Hindi",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            color = mainFontColor
                        )
                    }
                }

                //english
                Box(contentAlignment = Alignment.Center) {
                    Box(modifier = Modifier
                        .width(135.dp)
                        .height(49.dp)
                        .clip(RoundedCornerShape(100))
                        .clickable { selected = "English" }
                        .background(
                            if (selected == "English") sec2SelectedUnder else Color.Transparent
                        ))
                    Box(
                        modifier = Modifier
                            .width(127.dp)
                            .height(41.dp)
                            .clip(RoundedCornerShape(100))
                            .background(
                                sec2English
                            ), contentAlignment = Alignment.Center
                    )
                    {
                        Text(
                            text = "English",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            color = mainFontColor
                        )
                    }
                }

                //Spanish
                Box(contentAlignment = Alignment.Center) {
                    Box(modifier = Modifier
                        .width(135.dp)
                        .height(49.dp)
                        .clip(RoundedCornerShape(100))
                        .clickable { selected = "Spanish" }
                        .background(
                            if (selected == "Spanish") sec2SelectedUnder else Color.Transparent
                        ))
                    Box(
                        modifier = Modifier
                            .width(127.dp)
                            .height(41.dp)
                            .clip(RoundedCornerShape(100))
                            .background(
                                sec2Spanish
                            ), contentAlignment = Alignment.Center
                    )
                    {
                        Text(
                            text = "Spanish",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            color = mainFontColor
                        )
                    }
                }

                //Persian
                Box(contentAlignment = Alignment.Center) {
                    Box(modifier = Modifier
                        .width(135.dp)
                        .height(49.dp)
                        .clip(RoundedCornerShape(100))
                        .clickable { selected = "Persian" }
                        .background(
                            if (selected == "Persian") sec2SelectedUnder else Color.Transparent
                        ))
                    Box(
                        modifier = Modifier
                            .width(127.dp)
                            .height(41.dp)
                            .clip(RoundedCornerShape(100))
                            .background(
                                sec2Persian
                            ), contentAlignment = Alignment.Center
                    )
                    {
                        Text(
                            text = "Persian",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            color = mainFontColor
                        )
                    }
                }


            }


        }
        //sec3

        //eof
    }
}
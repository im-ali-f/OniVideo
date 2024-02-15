package com.example.onivideo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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

@Composable
fun TVShowsComp(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(mainBGC).padding(10.dp)
    ) {
        //sec1
        val selected= Brush.horizontalGradient(
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
        if(language)genre=false
        else genre=true

        var languageColor=if(language)selected else unselected
        var genreColor=if(genre)selected else unselected

        Row (modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(100)).background(sec1BGCColor).padding(10.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
            Button(
                onClick = { language = true
                    genre = false},
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
                onClick = { genre = true
                    language = false},
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

        //sec3

        //eof
    }
}
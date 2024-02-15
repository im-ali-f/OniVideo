package com.example.onivideo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onivideo.ui.theme.brush1
import com.example.onivideo.ui.theme.brush2
import com.example.onivideo.ui.theme.mainBGC
import com.example.onivideo.ui.theme.mainFontColor
import com.example.onivideo.ui.theme.navBrush1
import com.example.onivideo.ui.theme.navBrush2

@Composable
fun SearchComp(navController: NavController) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val screenHeight = LocalConfiguration.current.screenHeightDp
    if(screenWidth<400){
        LazyColumn(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(mainBGC)
        ) {


            //row 1
            item {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(top=5.dp, start = 10.dp),
                        text = "Movies",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = mainFontColor
                    )
                    LazyRow(
                        Modifier
                            .fillMaxWidth()
                            .fillParentMaxHeight(0.32f)
                    ) {
                        item {
                            Spacer(modifier = Modifier.fillParentMaxWidth(0.015f))
                        }
                        items(videoList) {
                            Surface(
                                shape = RoundedCornerShape(8.dp), modifier = Modifier
                                    .fillMaxHeight()
                                    .fillParentMaxWidth(0.320f)
                                    .padding(5.dp)
                            ) {
                                Box(modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        Brush.horizontalGradient(
                                            colors = listOf(brush2, brush1)
                                        )
                                    )
                                    .clickable { /*ToDo:navigate with id to specific videopage*/ }) {
                                    var img = it["img"] as Array<Int>
                                    var premume = it["premume"] as Boolean


                                    if (premume) {
                                        Box(
                                            modifier = Modifier
                                                .align(Alignment.TopEnd)
                                                .padding(9.dp)
                                                .size(22.dp)
                                                .clip(shape = RoundedCornerShape(100.dp))
                                                .background(
                                                    Brush.horizontalGradient(
                                                        colors = listOf(navBrush1, navBrush2)
                                                    )
                                                ), contentAlignment = Alignment.Center
                                        ) {

                                            Icon(
                                                painterResource(id = R.drawable.premume15),
                                                "Small floating action button.",
                                                tint = mainFontColor
                                            )

                                        }
                                    }
                                    // Image(modifier = Modifier.padding(5.dp), contentScale = ContentScale.Fit,painter = painterResource(id = img[0] ) , contentDescription =null )
                                }
                            }
                        }
                    }
                }
            }










            //row 2
            item() {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(top=5.dp, start = 10.dp),
                        text = "TV Shows",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = mainFontColor
                    )
                    LazyRow(
                        Modifier
                            .fillMaxWidth()
                            .fillParentMaxHeight(0.23f)
                            .padding(top = 10.dp)
                    ) {
                        item{
                            Spacer(modifier = Modifier.width(10.dp))
                        }
                        items(videoList) {

                            if (it["release"] as String != "") {
                                Surface(
                                    shape = RoundedCornerShape(8.dp), modifier = Modifier
                                        .fillMaxHeight()
                                        .fillParentMaxWidth(0.475f)
                                        .padding(end = 10.dp)
                                ) {
                                    Box(modifier = Modifier
                                        .fillMaxSize()
                                        .background(
                                            Brush.horizontalGradient(
                                                colors = listOf(brush1, brush2)
                                            )
                                        )
                                        .clickable {
                                            /*ToDo:navigate with id to specific videopage*/
                                        }) {
                                        var img = it["img"] as Array<Int>
                                        var premume = it["premume"] as Boolean


                                        if (premume) {
                                            Box(
                                                modifier = Modifier
                                                    .align(Alignment.TopEnd)
                                                    .padding(9.dp)
                                                    .size(30.dp)
                                                    .clip(shape = RoundedCornerShape(100.dp))
                                                    .background(
                                                        Brush.horizontalGradient(
                                                            colors = listOf(navBrush1, navBrush2)
                                                        )
                                                    ), contentAlignment = Alignment.Center
                                            ) {

                                                Icon(
                                                    painterResource(id = R.drawable.premume),
                                                    "Small floating action button.",
                                                    tint = mainFontColor
                                                )

                                            }
                                        }


                                        //Image(contentScale = ContentScale.Fit,painter = painterResource(id = img[0] ) , contentDescription =null )
                                    }
                                }

                            }
                        }
                    }
                }
            }

            //row 3

            item() {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(top=5.dp, start = 10.dp),
                        text = "Sports",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = mainFontColor
                    )
                    LazyRow(
                        Modifier
                            .fillMaxWidth()
                            .fillParentMaxHeight(0.3f)
                            .padding(top = 10.dp)
                    ) {
                        item{
                            Spacer(modifier = Modifier.width(10.dp))
                        }
                        items(watchList) {
                            var name = it["name"] as String
                            Column (modifier = Modifier.padding(end=10.dp)){
                                Box(modifier = Modifier
                                    .width(160.dp)
                                    .height(100.dp)

                                    .clip(shape = RoundedCornerShape(8.dp))
                                    .background(
                                        Brush.horizontalGradient(
                                            colors = listOf(brush1, brush2)
                                        )
                                    )
                                    .clickable {
                                        /*ToDo:navigate with id to specific videopage*/
                                    }) {

                                    var premume = it["premume"] as Boolean


                                    if (premume) {
                                        Box(
                                            modifier = Modifier
                                                .align(Alignment.TopEnd)
                                                .padding(9.dp)
                                                .size(22.dp)
                                                .clip(shape = RoundedCornerShape(100.dp))
                                                .background(
                                                    Brush.horizontalGradient(
                                                        colors = listOf(navBrush1, navBrush2)
                                                    )
                                                ), contentAlignment = Alignment.Center
                                        ) {

                                            Icon(
                                                painterResource(id = R.drawable.premume15),
                                                "Small floating action button.",
                                                tint = mainFontColor
                                            )

                                        }
                                    }


                                    //Image(contentScale = ContentScale.Fit,painter = painterResource(id = img[0] ) , contentDescription =null )
                                }
                                Text(maxLines = 1, overflow = TextOverflow.Ellipsis,modifier = Modifier.padding(top=10.dp), text = "$name", fontSize = 14.sp, color = mainFontColor, fontWeight = FontWeight(600))
                            }

                        }
                    }
                }
            }

            //row 4

            item() {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(top=5.dp, start = 10.dp),
                        text = "Live TV",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = mainFontColor
                    )
                    LazyRow(
                        Modifier
                            .fillMaxWidth()
                            .fillParentMaxHeight(0.3f)
                            .padding(top = 10.dp)
                    ) {
                        item{
                            Spacer(modifier = Modifier.width(10.dp))
                        }
                        items(watchList) {
                            var name = it["name"] as String
                            Column (modifier = Modifier.padding(end=10.dp)){
                                Box(modifier = Modifier
                                    .width(160.dp)
                                    .height(100.dp)

                                    .clip(shape = RoundedCornerShape(8.dp))
                                    .background(
                                        Brush.horizontalGradient(
                                            colors = listOf(brush1, brush2)
                                        )
                                    )
                                    .clickable {
                                        /*ToDo:navigate with id to specific videopage*/
                                    }) {

                                    var premume = it["premume"] as Boolean


                                    if (premume) {
                                        Box(
                                            modifier = Modifier
                                                .align(Alignment.TopEnd)
                                                .padding(9.dp)
                                                .size(22.dp)
                                                .clip(shape = RoundedCornerShape(100.dp))
                                                .background(
                                                    Brush.horizontalGradient(
                                                        colors = listOf(navBrush1, navBrush2)
                                                    )
                                                ), contentAlignment = Alignment.Center
                                        ) {

                                            Icon(
                                                painterResource(id = R.drawable.premume15),
                                                "Small floating action button.",
                                                tint = mainFontColor
                                            )

                                        }
                                    }


                                    //Image(contentScale = ContentScale.Fit,painter = painterResource(id = img[0] ) , contentDescription =null )
                                }
                                Text(maxLines = 1, overflow = TextOverflow.Ellipsis,modifier = Modifier.padding(top=10.dp), text = "$name", fontSize = 14.sp, color = mainFontColor, fontWeight = FontWeight(600))
                            }

                        }
                    }
                }
            }



            //row x



        }
    }
}
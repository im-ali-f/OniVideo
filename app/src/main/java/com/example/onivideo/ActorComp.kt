package com.example.onivideo

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onivideo.ui.theme.brush1
import com.example.onivideo.ui.theme.brush2
import com.example.onivideo.ui.theme.mainBGC
import com.example.onivideo.ui.theme.mainFontColor
import com.example.onivideo.ui.theme.navBrush1
import com.example.onivideo.ui.theme.navBrush2
import com.example.onivideo.ui.theme.redFontColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ActorComp(navController: NavController) {
    var scroll = rememberScrollState()
    Column(
        Modifier
            .fillMaxSize()
            .background(mainBGC)
            .verticalScroll(scroll)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(7.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(150.dp)
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(brush2, brush1)
                        )
                    )
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(Modifier.fillMaxWidth()) {
                Text(
                    text = "Ali Farhad",
                    fontSize = 15.sp,
                    fontWeight = FontWeight(700),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Place of Birth: ",
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600),
                        color = Color.White
                    )
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {

                        Text(
                            text = "Asia Middle East Iran Qazvin Qazvin Danaeshgah ST",
                            fontWeight = FontWeight(300),
                            fontSize = 14.sp,
                            color = mainFontColor,
                            letterSpacing = 0.6.sp,
                            maxLines = 1,
                            modifier = Modifier
                                .basicMarquee(
                                    animationMode = MarqueeAnimationMode.Immediately,
                                    delayMillis = 0,
                                    iterations = 1000
                                )
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(20.dp)
                                .background(
                                    Brush.horizontalGradient(
                                        colors = listOf(
                                            mainBGC,
                                            Color.Transparent,
                                            Color.Transparent,
                                            mainBGC
                                        )
                                    )
                                )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(5.dp))

                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Birthday: ",
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600),
                        color = Color.White
                    )


                    Text(
                        text = "2 June 2002",
                        fontWeight = FontWeight(300),
                        fontSize = 14.sp,
                        color = mainFontColor,
                        letterSpacing = 0.6.sp,
                        maxLines = 1,

                        )


                }
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = buildAnnotatedString {

                        withStyle(
                            style = SpanStyle(
                                fontSize = 14.sp, fontWeight = FontWeight(600), color = Color.White
                            )
                        ) {
                            append("Bio:")
                        }

                        withStyle(
                            style = SpanStyle(
                                fontSize = 13.sp,
                                fontWeight = FontWeight(300),
                                letterSpacing = 1.sp,
                                color = mainFontColor
                            )
                        ) {
                            append("is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")
                        }


                    },
                )


                Spacer(modifier = Modifier.height(15.dp))
            }
        }

        Column(Modifier.fillMaxWidth().padding(7.dp)) {
            Text(
                text = "TV Shows",
                fontSize = 15.sp,
                fontWeight = FontWeight(700),
                color = Color.White
            )
            Spacer(modifier = Modifier.height(10.dp))
        }

        LazyVerticalStaggeredGrid(
            userScrollEnabled = false,
            modifier = Modifier
                .fillMaxWidth()
                .height(630.dp)
                .background(mainBGC)
                .padding(top = 5.dp),
            columns = StaggeredGridCells.Fixed(2),
            content = {
                items(TVShowsList) {
                        Column (modifier = Modifier.padding(4.dp)){
                            Box(modifier = Modifier
                                .fillMaxWidth()
                                .height(95.dp)

                                .clip(shape = RoundedCornerShape(8.dp))
                                .background(
                                    Brush.horizontalGradient(
                                        colors = listOf(brush1, brush2)
                                    )
                                )
                                .clickable {
                                    navController.navigate("specificMoviePage")
                                }) {
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


                                //Image(contentScale = ContentScale.Fit,painter = painterResource(id = img[0] ) , contentDescription =null )
                            }
                        }



                }
            }
        )



    }

}
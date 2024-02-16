package com.example.onivideo

import android.widget.Space
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onivideo.ui.theme.IMDBContainerColor
import com.example.onivideo.ui.theme.brush1
import com.example.onivideo.ui.theme.brush2
import com.example.onivideo.ui.theme.disabledIcon
import com.example.onivideo.ui.theme.mainBGC
import com.example.onivideo.ui.theme.mainFontColor
import com.example.onivideo.ui.theme.moviePlayUnderColor
import com.example.onivideo.ui.theme.navBrush1
import com.example.onivideo.ui.theme.navBrush2
import com.example.onivideo.ui.theme.redFontColor
import com.example.onivideo.ui.theme.seperatorColor

@OptIn(ExperimentalFoundationApi::class)
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
                Box(
                    contentAlignment = Alignment.Center, modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.Black)
                            )
                        )
                ) {
                    Box(
                        modifier = Modifier
                            .size(75.dp)
                            .clip(RoundedCornerShape(100))
                            .background(
                                moviePlayUnderColor
                            )
                    )
                    Box(modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(100))
                        .clickable { }
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(navBrush1, navBrush2)
                            )
                        ), contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.fillMaxSize(),
                            imageVector = Icons.Rounded.PlayArrow,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }

            }
            IconButton(modifier = Modifier.align(Alignment.TopStart), onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )

            }


        }
        var verticScroll = rememberScrollState()
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(verticScroll)
        )
        {
            //sec 2 name + imdb
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Text(
                    text = "Inception",
                    fontWeight = FontWeight(600),
                    fontSize = 15.sp,
                    color = mainFontColor,
                    maxLines = 1,
                    letterSpacing = 0.8.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(100))
                        .background(IMDBContainerColor)
                        .padding(start = 4.dp, top = 2.dp, bottom = 2.dp, end = 4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "IMDB 7.0", fontWeight = FontWeight(400),
                        style = TextStyle(
                            brush = Brush.horizontalGradient(
                                colors = listOf(navBrush1, navBrush2)
                            )
                        ),
                        fontSize = 11.sp, maxLines = 1, letterSpacing = 0.7.sp,
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                var scrollState = rememberScrollState()
                val infoArray = arrayOf(
                    "May 05 2022",
                    "111 min",
                    "Views 47",
                    "Hindi",
                    "Comedy",
                    "Action",
                    "Drama",
                    " 25 Comments"
                )
                var counter = 1
                Row(
                    modifier = Modifier
                        .horizontalScroll(scrollState)
                        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
                ) {
                    infoArray.forEach { item ->
                        Text(
                            text = item,
                            fontWeight = FontWeight(400),
                            fontSize = 10.sp,
                            color = mainFontColor,
                            maxLines = 1,
                            letterSpacing = 0.5.sp
                        )
                        counter += 1
                        if (counter <= infoArray.size) {
                            Spacer(modifier = Modifier.width(7.dp))
                            Box(
                                modifier = Modifier
                                    .size(6.dp)
                                    .clip(RoundedCornerShape(100))
                                    .background(
                                        redFontColor
                                    )
                            )
                            Spacer(modifier = Modifier.width(7.dp))
                        }


                    }


                }
            }


            //sec 3
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(5.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Share",
                    fontWeight = FontWeight(400),
                    fontSize = 12.sp,
                    color = mainFontColor,
                    maxLines = 1,
                    letterSpacing = 0.5.sp
                )
                Spacer(modifier = Modifier.width(5.dp))//facebook
                Image(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = null,
                    modifier = Modifier.clickable { })
                Spacer(modifier = Modifier.width(5.dp))//twiter
                Image(
                    painter = painterResource(id = R.drawable.twitter),
                    contentDescription = null,
                    modifier = Modifier.clickable { })
                Spacer(modifier = Modifier.width(5.dp))//whatsUp
                Image(
                    painter = painterResource(id = R.drawable.whatsapp),
                    contentDescription = null,
                    modifier = Modifier.clickable { })

            }

            //sec 4
            var addedTolist by remember {
                mutableStateOf(false)
            }
            var color = if (addedTolist) redFontColor else mainFontColor
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, start = 20.dp, end = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(Modifier.fillMaxWidth(0.4f)) {
                    Column(
                        modifier = Modifier.clickable { },
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = null,
                            tint = mainFontColor
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "Trailer",
                            fontWeight = FontWeight(600),
                            fontSize = 12.sp,
                            color = mainFontColor,
                            maxLines = 1,
                            letterSpacing = 1.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(25.dp))
                    Column(
                        modifier = Modifier.clickable {
                            if (addedTolist) addedTolist = false
                            else addedTolist = true
                        },
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            tint = color
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "My List",
                            fontWeight = FontWeight(600),
                            fontSize = 12.sp,
                            color = color,
                            maxLines = 1,
                            letterSpacing = 1.sp
                        )
                    }
                }


                Box(contentAlignment = Alignment.Center) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(100))
                            .background(
                                moviePlayUnderColor
                            )
                    )
                    Box(modifier = Modifier
                        .size(35.dp)
                        .clip(RoundedCornerShape(100))
                        .clickable { }
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(navBrush1, navBrush2)
                            )
                        ), contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(22.dp),
                            painter = painterResource(id = R.drawable.connecttotv),
                            contentDescription = null,
                            tint = disabledIcon
                        )
                    }
                }
            }

            //sec 5
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )
            {
                Text(
                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    fontWeight = FontWeight(300),
                    fontSize = 12.sp,
                    color = mainFontColor,
                    letterSpacing = 0.6.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Director: Ali Farhad",
                    fontWeight = FontWeight(300),
                    fontSize = 12.sp,
                    color = mainFontColor,
                    letterSpacing = 0.6.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Writer: Ali Farhad,ali farhad,farhad ali",
                    fontWeight = FontWeight(300),
                    fontSize = 12.sp,
                    color = mainFontColor,
                    letterSpacing = 0.6.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Actors: Ali Farhad,ali Farhad,farhad,ali",
                    fontWeight = FontWeight(300),
                    fontSize = 12.sp,
                    color = mainFontColor,
                    letterSpacing = 0.6.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Production: N/A",
                    fontWeight = FontWeight(300),
                    fontSize = 12.sp,
                    color = mainFontColor,
                    letterSpacing = 0.6.sp
                )
            }

            //sec 6
            Spacer(modifier = Modifier.height(15.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.5.dp)
                    .background(seperatorColor)
            )
            Spacer(modifier = Modifier.height(5.dp))

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                //title
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .height(20.dp)
                            .width(1.5.dp)
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(navBrush1, navBrush2)
                                )
                            )
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Actors",
                        fontWeight = FontWeight(700),
                        fontSize = 12.sp,
                        color = mainFontColor,
                        letterSpacing = 0.6.sp
                    )
                }
                //end title
                Spacer(modifier = Modifier.height(15.dp))
                var scrollState= rememberScrollState()
                Row(
                    Modifier
                        .fillMaxWidth()
                        .horizontalScroll(scrollState)) {
                    var actorsArray =
                        arrayOf("Ali farhad FaliArhad", "farhad","Al Pacino", "alii ff", "Ali Farhad")
                    actorsArray.forEach { actor ->
                        Column(modifier = Modifier.width(70.dp)) {
                            Box(modifier = Modifier
                                .size(65.dp)
                                .clip(RoundedCornerShape(100))
                                .background(
                                    Brush.horizontalGradient(
                                        colors = listOf(brush1, brush2)
                                    )
                                )
                                .clickable { })
                            Spacer(modifier = Modifier.height(10.dp))
                            Box(modifier =Modifier.fillMaxWidth(), contentAlignment = Alignment.Center ){

                                Text(
                                    text = actor,
                                    fontWeight = FontWeight(700),
                                    fontSize = 12.sp,
                                    color = mainFontColor,
                                    letterSpacing = 0.6.sp,
                                    maxLines = 1,
                                    modifier = Modifier
                                        .fillMaxWidth(0.7f)
                                        .basicMarquee(
                                            animationMode = MarqueeAnimationMode.Immediately,
                                            delayMillis = 0,
                                            iterations = 1000
                                        )
                                )
                                Box(modifier = Modifier
                                    .fillMaxWidth()
                                    .height(15.dp)
                                    .background(
                                        Brush.horizontalGradient(
                                            colors = listOf(
                                                mainBGC,
                                                Color.Transparent,
                                                Color.Transparent,
                                                mainBGC
                                            )
                                        )
                                    ) )
                            }

                        }


                    }
                }

                Spacer(modifier = Modifier.height(15.dp))
                //title
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .height(20.dp)
                            .width(1.5.dp)
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(navBrush1, navBrush2)
                                )
                            )
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Directors",
                        fontWeight = FontWeight(700),
                        fontSize = 12.sp,
                        color = mainFontColor,
                        letterSpacing = 0.6.sp
                    )
                }
                //end title
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    Modifier
                        .fillMaxWidth() ){

                        Column(modifier = Modifier.width(70.dp)) {
                            Box(modifier = Modifier
                                .size(65.dp)
                                .clip(RoundedCornerShape(100))
                                .background(
                                    Brush.horizontalGradient(
                                        colors = listOf(brush1, brush2)
                                    )
                                )
                                .clickable { })
                            Spacer(modifier = Modifier.height(10.dp))
                            Box(modifier =Modifier.fillMaxWidth(), contentAlignment = Alignment.Center ){

                                Text(
                                    text = "Ali Farhad",
                                    fontWeight = FontWeight(700),
                                    fontSize = 12.sp,
                                    color = mainFontColor,
                                    letterSpacing = 0.6.sp,
                                    maxLines = 1,
                                    modifier = Modifier
                                        .fillMaxWidth(0.7f)
                                        .basicMarquee(
                                            animationMode = MarqueeAnimationMode.Immediately,
                                            delayMillis = 0,
                                            iterations = 1000
                                        )
                                )
                                Box(modifier = Modifier
                                    .fillMaxWidth()
                                    .height(15.dp)
                                    .background(
                                        Brush.horizontalGradient(
                                            colors = listOf(
                                                mainBGC,
                                                Color.Transparent,
                                                Color.Transparent,
                                                mainBGC
                                            )
                                        )
                                    ) )
                            }

                        }



                }

            }

            //sec 7
            Spacer(modifier = Modifier.height(15.dp))
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                //title
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .height(20.dp)
                            .width(1.5.dp)
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(navBrush1, navBrush2)
                                )
                            )
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Related Movies",
                        fontWeight = FontWeight(700),
                        fontSize = 12.sp,
                        color = mainFontColor,
                        letterSpacing = 0.6.sp
                    )
                }
                val screenWidth = LocalConfiguration.current.screenWidthDp
                val screenHeight = LocalConfiguration.current.screenHeightDp
                val height = if(screenWidth<400)160.dp else 200.dp
                //end title
                Spacer(modifier = Modifier.height(10.dp))
                LazyRow(
                    Modifier
                        .fillMaxWidth()
                        .height(height)
                ) {

                    items(videoList) {
                        Surface(
                            shape = RoundedCornerShape(8.dp), modifier = Modifier
                                .fillMaxHeight()
                                .fillParentMaxWidth(0.320f)
                                .padding(0.dp,5.dp,5.dp,5.dp)
                        ) {
                            Box(modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Brush.horizontalGradient(
                                        colors = listOf(brush2, brush1)
                                    )
                                )
                                .clickable { navController.navigate("specificMoviePage") }) {
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
            //sec x


        }

    }
}
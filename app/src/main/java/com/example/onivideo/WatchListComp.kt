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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
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

val watchList = arrayOf<Map<String, Any>>(
    mapOf(
        "id" to 1,
        "name" to "The Video 1",
        "poster" to R.drawable.poster,
        "img" to arrayOf(R.drawable.mimg, R.drawable.mimg, R.drawable.mimg, R.drawable.mimg),
        "genre" to arrayOf("Horror", "Comedy", "Action"),
        "language" to "English",
        "release" to "1/1/2022",
        "type" to "series",
        "actors" to arrayOf("ali", "mmd", "javad", "mina", "mona", "arman", "armin"),
        "description" to "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        "IMDB" to "9/10",
        "premume" to false,

        ),
    mapOf(
        "id" to 2,
        "name" to "The Video abcd efg 222",
        "poster" to R.drawable.poster,
        "img" to arrayOf(R.drawable.mimg, R.drawable.mimg, R.drawable.mimg, R.drawable.mimg),
        "genre" to arrayOf("Horror", "Comedy", "Western"),
        "language" to "English/US",
        "release" to "11/10/1990",
        "type" to "movie",
        "actors" to arrayOf("ali", "mmd", "javad", "mina", "mona", "arman", "armin"),
        "description" to "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        "IMDB" to "10/10",
        "premume" to false,

        ),
    mapOf(
        "id" to 3,
        "name" to "The 3",
        "poster" to R.drawable.poster,
        "img" to arrayOf(R.drawable.mimg, R.drawable.mimg, R.drawable.mimg, R.drawable.mimg),
        "genre" to arrayOf("Action", "Romantic", "Western"),
        "language" to "English",
        "release" to "10/1/2024",
        "type" to "series",
        "actors" to arrayOf("javad", "armin"),
        "description" to "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        "IMDB" to "5/10",
        "premume" to false,

        ),
    mapOf(
        "id" to 4,
        "name" to "The Video 4",
        "poster" to R.drawable.poster,
        "img" to arrayOf(R.drawable.mimg, R.drawable.mimg, R.drawable.mimg, R.drawable.mimg),
        "genre" to arrayOf("Horror", "Comedy", "Action"),
        "language" to "English",
        "release" to "1/1/2011",
        "type" to "movie",
        "actors" to arrayOf("ali", "mmd", "javad", "mina", "mona", "arman", "armin"),
        "description" to "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        "IMDB" to "9/10",
        "premume" to true,

        ),
    mapOf(
        "id" to 5,
        "name" to "The film of 5",
        "poster" to R.drawable.poster,
        "img" to arrayOf(R.drawable.mimg, R.drawable.mimg, R.drawable.mimg, R.drawable.mimg),
        "genre" to arrayOf("Horror", "Comedy", "Action"),
        "language" to "English",
        "release" to "",
        "type" to "series",
        "actors" to arrayOf("ali"),
        "description" to "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        "IMDB" to "n/10",
        "premume" to true,

        ),
    mapOf(
        "id" to 6,
        "name" to "The Video 6",
        "poster" to R.drawable.poster,
        "img" to arrayOf(R.drawable.mimg, R.drawable.mimg, R.drawable.mimg, R.drawable.mimg),
        "genre" to arrayOf("Horror", "Comedy", "Action"),
        "language" to "English",
        "release" to "",
        "type" to "series",
        "actors" to arrayOf("mina", "mona", "arman", "armin"),
        "description" to "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        "IMDB" to "n/10",
        "premume" to true,

        ),
    mapOf(
        "id" to 7,
        "name" to "The Video 7",
        "poster" to R.drawable.poster,
        "img" to arrayOf(R.drawable.mimg, R.drawable.mimg, R.drawable.mimg, R.drawable.mimg),
        "genre" to arrayOf("Horror", "Comedy", "Action"),
        "language" to "English",
        "release" to "",
        "type" to "series",
        "actors" to arrayOf("ali", "mmd", "javad", "mina", "mona", "arman", "armin"),
        "description" to "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        "IMDB" to "n/10",
        "premume" to false,

        ),

    )



@Composable
fun WatchListComp(navController: NavController){

        LazyVerticalStaggeredGrid(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(mainBGC),

            columns = StaggeredGridCells.Fixed(2),
            content = {
                items(watchList) {
                    var imgList=it["img"] as Array<Int>
                    var name = it["name"] as String
                    Column (modifier = Modifier.padding(5.dp)){
                        Box(modifier = Modifier
                            .fillMaxWidth()
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
                        Text(maxLines = 1, overflow = TextOverflow.Ellipsis,modifier = Modifier.padding(top=10.dp), text = "$name", fontSize = 15.sp, color = mainFontColor, fontWeight = FontWeight(750))
                    }

                }
            }
        )




}

@Composable
fun AsyncImage(model: Int, contentScale: Any, contentDescription: Nothing?, modifier: Any) {

}

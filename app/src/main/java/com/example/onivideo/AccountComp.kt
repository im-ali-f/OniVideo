package com.example.onivideo


import android.media.browse.MediaBrowser
import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Popup
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.example.onivideo.ui.theme.accCircleTempColor
import com.example.onivideo.ui.theme.accSectionsInnerColor
import com.example.onivideo.ui.theme.accSectionsOuterColor
import com.example.onivideo.ui.theme.mainFontColor
import com.example.onivideo.ui.theme.navBrush1
import com.example.onivideo.ui.theme.navBrush2
import com.example.onivideo.ui.theme.secondaryFontColor
import java.nio.file.WatchEvent


@Composable
fun AccountComp(navController: NavController) {

    val screenWidth = LocalConfiguration.current.screenWidthDp
    val screenHeight = LocalConfiguration.current.screenHeightDp


    //pop up
    var popup by remember {
        mutableStateOf(false)
    }
    @Composable
    fun SubscriptionComp(){
        //main column

        Popup{
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue) ) {

            }
        }


    }


    if (popup) {
        SubscriptionComp()
    }



    //now acc comp
    if (screenWidth < 400) {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(top = 30.dp)
                    .drawBehind {
                        drawCircle(
                            color = accCircleTempColor,
                            radius = 1100f,
                            center = Offset(370f, -1035f)
                        )
                    },
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .height(100.dp)
                        .padding(top = 5.dp)
                ) {
                    Surface(
                        modifier = Modifier
                            .size(50.dp), shape = RoundedCornerShape(100)
                    ) {
                        //inja bayad image profile beshine
                    }
                    Text(
                        text = "Ali",
                        fontSize = 15.sp,
                        color = mainFontColor,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "alifarhad.work@gmail.com",
                        fontSize = 10.sp,
                        color = secondaryFontColor,
                        fontWeight = FontWeight.Bold
                    )
                }
            }


            //sec 1
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp)//change
                    .padding(15.dp)

            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(10.dp))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.27f)
                            .background(accSectionsOuterColor), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Member Ship", fontSize = 16.sp,
                            color = mainFontColor,
                            fontWeight = FontWeight.Bold
                        )

                    }
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .background(accSectionsInnerColor)
                    ) {

                        Column(
                            Modifier
                                .fillMaxSize()
                                .padding(10.dp), verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                //row 1
                                Row(
                                    Modifier
                                        .fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Current Plan : ", fontSize = 15.sp,
                                        color = mainFontColor,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Box(
                                        modifier = Modifier
                                            .size(70.dp, 27.dp)
                                            .clip(RoundedCornerShape(4.dp))
                                            .background(accSectionsOuterColor),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = "Free Plan", fontSize = 13.sp,
                                            textAlign = TextAlign.Center,
                                            color = mainFontColor,
                                            fontWeight = FontWeight(600)
                                        )
                                    }
                                }
                                //row2

                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = "Subscription expires on january,  20 , 2024",
                                    fontSize = 14.sp,
                                    color = mainFontColor,
                                    letterSpacing = 1.sp,
                                    fontWeight = FontWeight(400)
                                )
                            }


                            //row 3
                            Button(
                                onClick = { popup = true },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(shape = RoundedCornerShape(4.dp))
                                    .background(
                                        Brush.horizontalGradient(
                                            colors = listOf(navBrush1, navBrush2)
                                        )
                                    )
                                    .height(35.dp),
                                shape = RoundedCornerShape(6.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                            ) {
                                Text(
                                    text = "Upgrade Plan", textAlign = TextAlign.Center,
                                    color = mainFontColor,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight(900)
                                )
                            }

                        }

                    }
                }

            }


            //sec 2
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)//change
                    .padding(15.dp)

            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(10.dp))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.14f)
                            .background(accSectionsOuterColor), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Account", fontSize = 16.sp,
                            color = mainFontColor,
                            fontWeight = FontWeight.Bold
                        )

                    }
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .background(accSectionsInnerColor)
                    ) {

                        Column(
                            Modifier
                                .fillMaxSize()
                                .padding(10.dp), verticalArrangement = Arrangement.SpaceBetween
                        ) {


                            Column(
                                Modifier
                                    .fillMaxHeight(0.8f)
                                    .padding(bottom = 15.dp),
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                //button
                                Button(
                                    onClick = { /*TODO: */ },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(shape = RoundedCornerShape(4.dp))
                                        .background(accSectionsOuterColor)
                                        .height(35.dp),
                                    shape = RoundedCornerShape(6.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                                    contentPadding = PaddingValues(start = 10.dp)
                                ) {
                                    Box(Modifier.fillMaxWidth()) {
                                        Text(
                                            text = "Dashboard", textAlign = TextAlign.Center,
                                            color = mainFontColor,
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight(600)
                                        )
                                    }

                                }
                                //button
                                Button(
                                    onClick = { /*TODO: */ },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(shape = RoundedCornerShape(4.dp))
                                        .background(accSectionsOuterColor)
                                        .height(35.dp),
                                    shape = RoundedCornerShape(6.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                                    contentPadding = PaddingValues(start = 10.dp)
                                ) {
                                    Box(Modifier.fillMaxWidth()) {
                                        Text(
                                            text = "Edit Profile", textAlign = TextAlign.Center,
                                            color = mainFontColor,
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight(600)
                                        )
                                    }

                                }
                                //button
                                Button(
                                    onClick = { /*TODO: */ },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(shape = RoundedCornerShape(4.dp))
                                        .background(accSectionsOuterColor)
                                        .height(35.dp),
                                    shape = RoundedCornerShape(6.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                                    contentPadding = PaddingValues(start = 10.dp)
                                ) {
                                    Box(Modifier.fillMaxWidth()) {
                                        Text(
                                            text = "Delete Account", textAlign = TextAlign.Center,
                                            color = mainFontColor,
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight(600)
                                        )
                                    }

                                }
                            }


                            //last btn
                            Button(
                                onClick = { /*TODO: nav to upgrade */ },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(shape = RoundedCornerShape(4.dp))
                                    .background(
                                        Brush.horizontalGradient(
                                            colors = listOf(navBrush1, navBrush2)
                                        )
                                    )
                                    .height(35.dp),
                                shape = RoundedCornerShape(6.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                            ) {
                                Text(
                                    text = "Logout", textAlign = TextAlign.Center,
                                    color = mainFontColor,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight(900)
                                )
                            }

                        }

                    }
                }

            }


        }


    } else {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .padding(top = 30.dp)
                    .drawBehind {
                        drawCircle(
                            color = accCircleTempColor,
                            radius = 1300f,
                            center = Offset(535f, -1170f)
                        )
                    },
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .height(120.dp)
                        .padding(top = 5.dp)
                ) {
                    Surface(
                        modifier = Modifier
                            .size(60.dp), shape = RoundedCornerShape(100)
                    ) {
                        //inja bayad image profile beshine
                    }
                    Text(
                        text = "Ali",
                        fontSize = 18.sp,
                        color = mainFontColor,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "alifarhad.work@gmail.com",
                        fontSize = 13.sp,
                        color = secondaryFontColor,
                        fontWeight = FontWeight.Bold
                    )
                }
            }


            //sec 1
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(210.dp)//change
                    .padding(15.dp)

            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(10.dp))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.25f)
                            .background(accSectionsOuterColor), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Member Ship", fontSize = 18.sp,
                            color = mainFontColor,
                            fontWeight = FontWeight.Bold
                        )

                    }
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .background(accSectionsInnerColor)
                    ) {

                        Column(
                            Modifier
                                .fillMaxSize()
                                .padding(10.dp), verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                //row 1
                                Row(
                                    Modifier
                                        .fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Current Plan : ", fontSize = 18.sp,
                                        color = mainFontColor,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Box(
                                        modifier = Modifier
                                            .size(90.dp, 35.dp)
                                            .clip(RoundedCornerShape(4.dp))
                                            .background(accSectionsOuterColor),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = "Free Plan", fontSize = 15.sp,
                                            textAlign = TextAlign.Center,
                                            color = mainFontColor,
                                            fontWeight = FontWeight(600)
                                        )
                                    }
                                }
                                //row2

                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = "Subscription expires on january, 20 ,2024",
                                    fontSize = 15.sp,
                                    color = mainFontColor,
                                    letterSpacing = 1.sp,
                                    fontWeight = FontWeight(400)
                                )
                            }


                            //row 3

                            Button(
                                onClick = { popup = true},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(shape = RoundedCornerShape(4.dp))
                                    .background(
                                        Brush.horizontalGradient(
                                            colors = listOf(navBrush1, navBrush2)
                                        )
                                    )
                                    .height(45.dp),
                                shape = RoundedCornerShape(6.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                            ) {
                                Text(
                                    text = "Upgrade Plan", textAlign = TextAlign.Center,
                                    color = mainFontColor,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(900)
                                )
                            }

                        }

                    }
                }

            }


            //sec 2
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)//change
                    .padding(15.dp)

            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(10.dp))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.16f)
                            .background(accSectionsOuterColor), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Account", fontSize = 19.sp,
                            color = mainFontColor,
                            fontWeight = FontWeight.Bold
                        )

                    }
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .background(accSectionsInnerColor)
                    ) {

                        Column(
                            Modifier
                                .fillMaxSize()
                                .padding(10.dp), verticalArrangement = Arrangement.SpaceBetween
                        ) {


                            Column(
                                Modifier
                                    .fillMaxHeight(0.8f)
                                    .padding(bottom = 15.dp),
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                //button
                                Button(
                                    onClick = { /*TODO: */ },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(shape = RoundedCornerShape(4.dp))
                                        .background(accSectionsOuterColor)
                                        .height(45.dp),
                                    shape = RoundedCornerShape(6.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                                    contentPadding = PaddingValues(start = 10.dp)
                                ) {
                                    Box(Modifier.fillMaxWidth()) {
                                        Text(
                                            text = "Dashboard", textAlign = TextAlign.Center,
                                            color = mainFontColor,
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight(600)
                                        )
                                    }

                                }
                                //button
                                Button(
                                    onClick = { /*TODO: */ },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(shape = RoundedCornerShape(4.dp))
                                        .background(accSectionsOuterColor)
                                        .height(45.dp),
                                    shape = RoundedCornerShape(6.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                                    contentPadding = PaddingValues(start = 10.dp)
                                ) {
                                    Box(Modifier.fillMaxWidth()) {
                                        Text(
                                            text = "Edit Profile", textAlign = TextAlign.Center,
                                            color = mainFontColor,
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight(600)
                                        )
                                    }

                                }
                                //button
                                Button(
                                    onClick = { /*TODO: */ },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(shape = RoundedCornerShape(4.dp))
                                        .background(accSectionsOuterColor)
                                        .height(45.dp),
                                    shape = RoundedCornerShape(6.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                                    contentPadding = PaddingValues(start = 10.dp)
                                ) {
                                    Box(Modifier.fillMaxWidth()) {
                                        Text(
                                            text = "Delete Account", textAlign = TextAlign.Center,
                                            color = mainFontColor,
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight(600)
                                        )
                                    }

                                }
                            }


                            //last btn
                            Button(
                                onClick = { /*TODO: nav to upgrade */ },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(shape = RoundedCornerShape(4.dp))
                                    .background(
                                        Brush.horizontalGradient(
                                            colors = listOf(navBrush1, navBrush2)
                                        )
                                    )
                                    .height(45.dp),
                                shape = RoundedCornerShape(6.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                            ) {
                                Text(
                                    text = "Logout", textAlign = TextAlign.Center,
                                    color = mainFontColor,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(900)
                                )
                            }

                        }

                    }
                }

            }


        }
    }


}






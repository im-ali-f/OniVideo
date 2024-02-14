package com.example.onivideo

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onivideo.ui.theme.accSectionsInnerColor
import com.example.onivideo.ui.theme.accSectionsOuterColor
import com.example.onivideo.ui.theme.mainBGC
import com.example.onivideo.ui.theme.mainFontColor
import com.example.onivideo.ui.theme.navBrush1
import com.example.onivideo.ui.theme.navBrush2
import com.example.onivideo.ui.theme.redFontColor
import com.example.onivideo.ui.theme.scaffoldHeadalphaColor
import com.example.onivideo.ui.theme.seperatorColor
import com.example.onivideo.ui.theme.seperatorColor2

@Composable
fun DashboardComp(navController: NavController) {
    var scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(mainBGC)
            .verticalScroll(scrollState)
    ) {

        //sec 1
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(145.dp)//change
                .padding(15.dp, 5.dp, 15.dp, 5.dp)


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
                        text = "User Profile", fontSize = 13.sp,
                        color = mainFontColor,
                        fontWeight = FontWeight(500)
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

                    Row(
                        Modifier
                            .fillMaxSize()
                            .padding(10.dp), horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        //prof img
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxHeight()
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(100))
                                    .background(
                                        Color.Black
                                    )
                                    .size(68.dp)
                            )
                            Box(
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(100))
                                    .background(
                                        Color.White
                                    )
                                    .size(63.dp)
                            )

                        }
                        //name and email
                        Column(
                            modifier = Modifier
                                .padding(start = 5.dp)
                                .width(180.dp)

                                .fillMaxHeight(), verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Ali",
                                fontSize = 16.sp,
                                fontWeight = FontWeight(500),
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.height(3.dp))
                            Text(
                                text = "alifarhad.work@gmail.com",
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontSize = 12.sp,
                                fontWeight = FontWeight(400),
                                color = mainFontColor
                            )
                        }


                        //edit btn

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(100))
                                .background(
                                    Brush.horizontalGradient(
                                        colors = listOf(navBrush1, navBrush2)
                                    )
                                )
                                .height(28.dp)
                                .width(45.dp),
                            shape = RoundedCornerShape(100),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text(
                                text = "Edit", textAlign = TextAlign.Center,
                                color = mainFontColor,
                                fontSize = 11.sp,
                                fontWeight = FontWeight(600)
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
                .height(165.dp)
                .padding(15.dp, 5.dp, 15.dp, 5.dp)

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
                        text = "My Subscription", fontSize = 13.sp,
                        color = mainFontColor,
                        fontWeight = FontWeight(500)
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
                            fontWeight = FontWeight(300)
                        )


                        //row 3
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth(0.35f)
                                .clip(shape = RoundedCornerShape(100))
                                .background(
                                    Brush.horizontalGradient(
                                        colors = listOf(navBrush1, navBrush2)
                                    )
                                )
                                .height(30.dp),
                            shape = RoundedCornerShape(100),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text(
                                text = "Upgrade Plan", textAlign = TextAlign.Center,
                                color = mainFontColor,
                                fontSize = 15.sp,
                                fontWeight = FontWeight(400)
                            )
                        }

                    }

                }
            }

        }

        //sec 3
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)//change
                .padding(15.dp, 5.dp, 15.dp, 5.dp)

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
                        text = "Last Invoice", fontSize = 13.sp,
                        color = mainFontColor,
                        fontWeight = FontWeight(500)
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

                        //row 1
                        Row(
                            Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Date : ", fontSize = 13.sp,
                                color = mainFontColor,
                                fontWeight = FontWeight(500)
                            )
                            Box(
                                modifier = Modifier
                                    .height(25.dp)
                                    .width(120.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(accSectionsOuterColor),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "January, 19, 2024", fontSize = 13.sp,
                                    textAlign = TextAlign.Center,
                                    color = mainFontColor,
                                    fontWeight = FontWeight(400)
                                )
                            }
                        }
                        //row2
                        Row(
                            Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Plan : ", fontSize = 13.sp,
                                color = mainFontColor,
                                fontWeight = FontWeight(500)
                            )
                            Box(
                                modifier = Modifier
                                    .height(25.dp)
                                    .width(70.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(accSectionsOuterColor),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Free Plan", fontSize = 13.sp,
                                    textAlign = TextAlign.Center,
                                    color = mainFontColor,
                                    fontWeight = FontWeight(400)
                                )
                            }
                        }


                        //row 3
                        Row(
                            Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Amount : ", fontSize = 13.sp,
                                color = mainFontColor,
                                fontWeight = FontWeight(500)
                            )
                            Box(
                                modifier = Modifier
                                    .height(25.dp)
                                    .width(45.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(accSectionsOuterColor),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "0.00", fontSize = 13.sp,
                                    textAlign = TextAlign.Center,
                                    color = mainFontColor,
                                    fontWeight = FontWeight(400)
                                )
                            }
                        }

                        //end part 3


                    }

                }


            }


        }
        //sec 4 Text
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp, 5.dp, 15.dp, 5.dp)) {
            Text(
                text = "User Transactions",
                fontWeight = FontWeight(400),
                fontSize = 13.sp,
                color = mainFontColor
            )
        }
        // sec 4
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(125.dp)//change
                .padding(15.dp, 5.dp, 15.dp, 5.dp)

        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.27f)
                        .background(accSectionsInnerColor)
                        .padding(10.dp,5.dp,5.dp,5.dp)
                        , verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Free Plan", fontSize = 12.sp,
                        color = mainFontColor,
                        fontWeight = FontWeight(600)
                    )

                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.5.dp)
                        .background(seperatorColor2)
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

                        //row 1
                        Row(
                            Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Payment Date ", fontSize = 12.sp,
                                color = mainFontColor,
                                fontWeight = FontWeight(500)
                            )

                            Text(
                                text = "Jan 19 2024 05:55 AM", fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                color = mainFontColor,
                                fontWeight = FontWeight(500)
                            )

                        }
                        //row2
                        Row(
                            Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Amount ", fontSize = 12.sp,
                                color = mainFontColor,
                                fontWeight = FontWeight(500)
                            )

                            Text(
                                text = "0.00 USD", fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                color = redFontColor,
                                fontWeight = FontWeight(500)
                            )

                        }

                        //row 3
                        Row(
                            Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Total Amount", fontSize = 12.sp,
                                color = mainFontColor,
                                fontWeight = FontWeight(500)
                            )

                            Text(
                                text = "29.35 USD", fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                color = redFontColor,
                                fontWeight = FontWeight(500)
                            )

                        }

                        //end part 3


                    }

                }


            }


        }

    }

}
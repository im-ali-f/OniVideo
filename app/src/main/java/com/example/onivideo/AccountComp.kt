package com.example.onivideo


import android.media.browse.MediaBrowser
import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.twotone.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
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
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
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
import com.example.onivideo.ui.theme.closePopupColor
import com.example.onivideo.ui.theme.mainBGC
import com.example.onivideo.ui.theme.mainFontColor
import com.example.onivideo.ui.theme.navBrush1
import com.example.onivideo.ui.theme.navBrush2
import com.example.onivideo.ui.theme.popupInnerSectionColor
import com.example.onivideo.ui.theme.popupPaymentColor
import com.example.onivideo.ui.theme.popupSectionColor
import com.example.onivideo.ui.theme.radioButtonColor
import com.example.onivideo.ui.theme.redFontColor
import com.example.onivideo.ui.theme.secondaryFontColor
import com.example.onivideo.ui.theme.seperatorColor
import kotlinx.coroutines.selects.select
import java.nio.file.WatchEvent


@Composable
fun AccountComp(navController: NavController) {

    val screenWidth = LocalConfiguration.current.screenWidthDp
    val screenHeight = LocalConfiguration.current.screenHeightDp


    //pop up
    var popup by remember {
        mutableStateOf(true)
    }

    var payPopup by remember {
        mutableStateOf(true)
    }


    @Composable
    fun SubscriptionComp() {
        //main column

        Popup {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(mainBGC)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp), horizontalArrangement = Arrangement.End
                ) {
                    IconButton(
                        onClick = { popup = false }, modifier = Modifier
                            .clip(shape = RoundedCornerShape(100))
                            .background(
                                Color.White
                            )
                            .size(30.dp)

                    ) {
                        Icon(
                            imageVector = Icons.TwoTone.Close,
                            contentDescription = "close popup",
                            tint = closePopupColor
                        )

                    }

                }


                //texts
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Subscription Plan",
                        fontSize = 25.sp,
                        fontWeight = FontWeight(900),
                        color = mainFontColor
                    )

                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(15.dp)
                    )

                    Text(
                        text = "Full access to all free and premume content",
                        fontSize = 15.sp,
                        fontWeight = FontWeight(500),
                        color = secondaryFontColor
                    )
                    Text(
                        text = "with download also. choose plan based on your",
                        fontSize = 15.sp,
                        fontWeight = FontWeight(500),
                        color = secondaryFontColor
                    )
                    Text(
                        text = "usage. Below there are plam name,price and",
                        fontSize = 15.sp,
                        fontWeight = FontWeight(500),
                        color = secondaryFontColor
                    )
                    Text(
                        text = "validity days. for explose select free plan",
                        fontSize = 15.sp,
                        fontWeight = FontWeight(500),
                        color = secondaryFontColor
                    )
                }

                //plan section
                val scrollState = rememberScrollState()
                Column(
                    Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                        .background(popupSectionColor),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {


                    //p1
                    Column {
                        Box(
                            contentAlignment = Alignment.Center, modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.14f)
                                .padding(15.dp)
                        ) {
                            Text(
                                text = "Select Your Subscription Plan",
                                fontSize = 17.sp,
                                fontWeight = FontWeight(600),
                                color = mainFontColor
                            )
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.5.dp)
                                .background(seperatorColor)
                        )
                    }


                    //plans list

                    val radioList = listOf<String>("Basic", "Premume", "Platinum", "Free")
                    var (selectedItem, selected) = remember {
                        mutableStateOf(radioList[0])
                    }
                    var height= if(screenWidth <400)0.77f else 0.85f
                    Column(
                        modifier = Modifier
                            .selectableGroup()
                            .fillMaxWidth()
                            .fillMaxHeight(height)
                            .verticalScroll(scrollState)
                            .padding(10.dp, 10.dp, 10.dp, 0.dp),

                    ) {

                        radioList.forEach { item ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(85.dp)
                                    .clip(shape = RoundedCornerShape(5.dp))
                                    .background(popupInnerSectionColor)
                                    .selectable(
                                        selected = (selectedItem == item),
                                        onClick = { selected(item) },
                                        role = Role.RadioButton
                                    )
                            ) {
                                RadioButton(modifier = Modifier.fillMaxHeight(),
                                    colors = RadioButtonDefaults.colors(
                                    selectedColor = radioButtonColor,
                                    unselectedColor = Color.White
                                ),
                                    selected = (selectedItem == item), onClick = { selected(item) })


                                Column(Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                                    var price = when(item){
                                        "Basic" -> "10.00"
                                        "Premume" -> "29.99"
                                        "Platinum" -> "99.00"
                                        "Free" -> "0.00"
                                        else -> ""

                                    }

                                    var time = when(item){
                                        "Basic" -> "7 Day(s)"
                                        "Premume" -> "1 Month(s)"
                                        "Platinum" -> "1 Year(s)"
                                        "Free" -> "1 Day(s)"
                                        else -> ""

                                    }
                                    Text(
                                        text = buildAnnotatedString {

                                            withStyle(style = SpanStyle(fontSize = 32.sp,
                                                fontWeight = FontWeight(900),
                                                color = mainFontColor)){
                                                append(price)
                                            }

                                            withStyle(style = SpanStyle(fontSize = 16.sp,
                                                fontWeight = FontWeight(700),
                                                color = mainFontColor)){
                                                append("   USD / For "+time)
                                            }
                                        },

                                    )
                                    Text(
                                        text = item + " Plan",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight(500),
                                        color = mainFontColor
                                    )
                                }
                            }
                            Spacer(modifier = Modifier
                                .fillMaxWidth()
                                .height(10.dp))
                        }

                    }
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)){

                        Button(
                            onClick = { payPopup = true },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(4.dp))
                                .background(
                                    Brush.horizontalGradient(
                                        colors = listOf(navBrush1, navBrush2)
                                    )
                                )
                                .height(50.dp),
                            shape = RoundedCornerShape(6.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                            contentPadding = PaddingValues(start = 10.dp)
                        ) {
                            Text(
                                text = "PROCEED", textAlign = TextAlign.Center,
                                color = mainFontColor,
                                fontSize = 17.sp,
                                fontWeight = FontWeight(600)
                            )
                        }

                    }

                }

                //button


            }
        }


    }



    if (popup) {
        SubscriptionComp()
    }
    @Composable
    fun PayComp(){
        Popup {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(mainBGC)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp), horizontalArrangement = Arrangement.End
                ) {
                    IconButton(
                        onClick = { payPopup = false }, modifier = Modifier
                            .clip(shape = RoundedCornerShape(100))
                            .background(
                                Color.White
                            )
                            .size(30.dp)

                    ) {
                        Icon(
                            imageVector = Icons.TwoTone.Close,
                            contentDescription = "close popup",
                            tint = closePopupColor
                        )

                    }

                }
                //main column( hame injan joz close)
                var scrollSt= rememberScrollState()
                Column(modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollSt)) {
                    //sec 1
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(85.dp)
                            .padding(start = 10.dp, end = 10.dp)
                            .clip(shape = RoundedCornerShape(5.dp))
                            .background(popupInnerSectionColor)
                            .selectable(
                                selected = true,
                                onClick = {},
                                role = Role.RadioButton
                            )
                    ) {
                        RadioButton(modifier = Modifier.fillMaxHeight(),
                            colors = RadioButtonDefaults.colors(
                                selectedColor = radioButtonColor,
                                unselectedColor = Color.White
                            ),
                            selected = true, onClick = {})


                        Column(Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                            var price = "10.00"

                            var time = "7 Day(s)"

                            Text(
                                text = buildAnnotatedString {

                                    withStyle(style = SpanStyle(fontSize = 32.sp,
                                        fontWeight = FontWeight(900),
                                        color = mainFontColor)){
                                        append(price)
                                    }

                                    withStyle(style = SpanStyle(fontSize = 16.sp,
                                        fontWeight = FontWeight(700),
                                        color = mainFontColor)){
                                        append("   USD / For "+time)
                                    }
                                },

                                )
                            Text(
                                text = "Basic" + " Plan",
                                fontSize = 16.sp,
                                fontWeight = FontWeight(500),
                                color = mainFontColor
                            )
                        }
                    }


                    //sec 2
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(230.dp)//change
                            .padding(10.dp, 15.dp, 10.dp, 5.dp)

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
                                    text = "User Information", fontSize = 16.sp,
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
                                                text = "You have selected:- ", fontSize = 15.sp,
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
                                                    text = "Basic Plan", fontSize = 13.sp,
                                                    textAlign = TextAlign.Center,
                                                    color = mainFontColor,
                                                    fontWeight = FontWeight(600)
                                                )
                                            }
                                        }
                                        //row2

                                        Text(text =buildAnnotatedString {

                                            withStyle(style = SpanStyle(fontSize = 14.sp,
                                                color = mainFontColor,
                                                letterSpacing = 0.6.sp,
                                                fontWeight = FontWeight(400))){
                                                append("You are logged in as ")
                                            }

                                            withStyle(style = SpanStyle(fontSize = 14.sp,
                                                color = redFontColor,
                                                letterSpacing = 0.6.sp,
                                                fontWeight = FontWeight(400))){
                                                append("sample@gmail.com")
                                            }

                                            withStyle(style = SpanStyle(fontSize = 14.sp,
                                                color = mainFontColor,
                                                letterSpacing = 0.6.sp,
                                                fontWeight = FontWeight(400))){
                                                append(". if you would like to use Diffrent account for this subscription,")
                                            }
                                            withStyle(style = SpanStyle(fontSize = 14.sp,
                                                color = redFontColor,
                                                letterSpacing = 0.6.sp,
                                                fontWeight = FontWeight(400))){
                                                append(" Logout ")
                                            }
                                            withStyle(style = SpanStyle(fontSize = 14.sp,
                                                color = mainFontColor,
                                                letterSpacing = 0.6.sp,
                                                fontWeight = FontWeight(400))){
                                                append("Now.")
                                            }
                                        })
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
                                            .height(40.dp),
                                        shape = RoundedCornerShape(6.dp),
                                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                                    ) {
                                        Text(
                                            text = "Change Plan", textAlign = TextAlign.Center,
                                            color = mainFontColor,
                                            fontSize = 19.sp,
                                            fontWeight = FontWeight(500)
                                        )
                                    }

                                }

                            }
                        }

                    }




                    //sec3
                    Box(modifier = Modifier.fillMaxWidth()){
                        Text(modifier = Modifier
                            .fillMaxWidth()
                            .clickable { /*todo:copun popup*/ },text = "I have copon code", fontSize = 16.sp, fontWeight = FontWeight(600), color = redFontColor, textAlign = TextAlign.Center,)

                    }


                    //sec4
                    var innerScrollState= rememberScrollState()
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp, 15.dp, 10.dp, 5.dp)


                    ) {
                        Column(
                            Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(10.dp))
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .background(accSectionsOuterColor), contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Payment Option", fontSize = 16.sp,
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

                                    //radio buttons ...



                                    val radioList = listOf<String>("Paypal", "Stipe", "Razorpay", "Paystack","Instamojo")
                                    var (selectedItem, selected) = remember {
                                        mutableStateOf("")
                                    }
                                        radioList.forEach { item ->
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .height(40.dp)
                                                    .clip(shape = RoundedCornerShape(5.dp))
                                                    .background(popupPaymentColor)
                                                    .selectable(
                                                        selected = (selectedItem == item),
                                                        onClick = { selected(item) },
                                                        role = Role.RadioButton
                                                    )
                                            ) {
                                                RadioButton(modifier = Modifier.fillMaxHeight(),
                                                    colors = RadioButtonDefaults.colors(
                                                        selectedColor = radioButtonColor,
                                                        unselectedColor = mainFontColor
                                                    ),
                                                    selected = (selectedItem == item), onClick = { selected(item) })


                                                Column(Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                                                    Text(
                                                        text = item,
                                                        fontSize = 16.sp,
                                                        fontWeight = FontWeight(500),
                                                        color = mainFontColor
                                                    )
                                                }
                                            }
                                            Spacer(modifier = Modifier
                                                .fillMaxWidth()
                                                .height(10.dp))
                                        }





                                    //end radio
                                }

                            }
                        }

                    }


                    //end
                }

            }
        }
    }

    if (payPopup){
        PayComp()
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
                                onClick = { popup = true },
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






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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onivideo.ui.theme.mainFontColor
import com.example.onivideo.ui.theme.seperatorColor
import com.example.onivideo.ui.theme.switchThumbColor
import com.example.onivideo.ui.theme.switchTrackColor

@Composable
fun SettingComp(navController: NavController){
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val screenHeight = LocalConfiguration.current.screenHeightDp
    if(screenWidth<400){
        Column(modifier = Modifier.fillMaxSize()) {

            Spacer(modifier = Modifier.height(15.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = seperatorColor))
            
            Row (
                Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                Text(text = "Enable Push Notification",color= mainFontColor, fontSize = 15.sp, fontWeight = FontWeight(600))
                var switchState by remember {
                    mutableStateOf(true)
                }
                Switch(checked = switchState, onCheckedChange = {new -> switchState=new},
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = switchThumbColor ,
                        checkedTrackColor = switchTrackColor,

                    ))
            }

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = seperatorColor))

            Button(onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
                , colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues(10.dp)
            ) {
                Box(modifier = Modifier.fillMaxWidth()){
                    Text(text = "About",color= mainFontColor, fontSize = 15.sp, fontWeight = FontWeight(600))
                }
            }

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = seperatorColor))


            Button(onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
                , colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues(10.dp)
            ) {
                Box(modifier = Modifier.fillMaxWidth()){
                    Text(text = "Privacy Policy",color= mainFontColor, fontSize = 15.sp, fontWeight = FontWeight(600))
                }
            }

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = seperatorColor))


            Button(onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
                , colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues(10.dp)
            ) {
                Box(modifier = Modifier.fillMaxWidth()){
                    Text(text = "Rate App",color= mainFontColor, fontSize = 15.sp, fontWeight = FontWeight(600))
                }
            }

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = seperatorColor))


            Button(onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
                , colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues(10.dp)
            ) {
                Box(modifier = Modifier.fillMaxWidth()){
                    Text(text = "Share App",color= mainFontColor, fontSize = 15.sp, fontWeight = FontWeight(600))
                }
            }

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = seperatorColor))


            Button(onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
                , colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues(10.dp)
            ) {
                Box(modifier = Modifier.fillMaxWidth()){
                    Text(text = "More App",color= mainFontColor, fontSize = 15.sp, fontWeight = FontWeight(600))
                }
            }

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = seperatorColor))

        }
    }
    else{
        Column(modifier = Modifier.fillMaxSize()) {

            Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = seperatorColor))

            Row (
                Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, top = 8.dp, bottom = 8.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                Text(text = "Enable Push Notification",color= mainFontColor, fontSize = 20.sp, fontWeight = FontWeight(600))
                var switchState by remember {
                    mutableStateOf(true)
                }
                Switch(checked = switchState, onCheckedChange = {new -> switchState=new},
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = switchThumbColor ,
                        checkedTrackColor = switchTrackColor,

                        ))
            }

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = seperatorColor))

            Button(onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
                , colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues(17.dp)
            ) {
                Box(modifier = Modifier.fillMaxWidth()){
                    Text(text = "About",color= mainFontColor, fontSize = 20.sp, fontWeight = FontWeight(600))
                }
            }

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(1.5.dp)
                .background(color = seperatorColor))


            Button(onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
                , colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues(17.dp)
            ) {
                Box(modifier = Modifier.fillMaxWidth()){
                    Text(text = "Privacy Policy",color= mainFontColor, fontSize = 20.sp, fontWeight = FontWeight(600))
                }
            }

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(1.5.dp)
                .background(color = seperatorColor))


            Button(onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
                , colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues(17.dp)
            ) {
                Box(modifier = Modifier.fillMaxWidth()){
                    Text(text = "Rate App",color= mainFontColor, fontSize = 20.sp, fontWeight = FontWeight(600))
                }
            }

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(1.5.dp)
                .background(color = seperatorColor))


            Button(onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
                , colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues(17.dp)
            ) {
                Box(modifier = Modifier.fillMaxWidth()){
                    Text(text = "Share App",color= mainFontColor, fontSize = 20.sp, fontWeight = FontWeight(600))
                }
            }

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = seperatorColor))


            Button(onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
                , colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues(17.dp)
            ) {
                Box(modifier = Modifier.fillMaxWidth()){
                    Text(text = "More App",color= mainFontColor, fontSize = 20.sp, fontWeight = FontWeight(600))
                }
            }

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(1.5.dp)
                .background(color = seperatorColor))

        }



    }
}
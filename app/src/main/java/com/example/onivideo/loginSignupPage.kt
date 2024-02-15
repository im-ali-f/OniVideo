package com.example.onivideo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onivideo.ui.theme.faceBookColorDarker
import com.example.onivideo.ui.theme.faceBookColorLighter
import com.example.onivideo.ui.theme.googleColorDarker
import com.example.onivideo.ui.theme.googleColorlighter
import com.example.onivideo.ui.theme.mainBGC
import com.example.onivideo.ui.theme.mainFontColor
import com.example.onivideo.ui.theme.navBrush1
import com.example.onivideo.ui.theme.navBrush2
import com.example.onivideo.ui.theme.popupInnerSectionColor
import com.example.onivideo.ui.theme.radioButtonColor
import com.example.onivideo.ui.theme.redFontColor
import com.example.onivideo.ui.theme.switchThumbColor
import com.example.onivideo.ui.theme.switchTrackColor
import com.example.onivideo.ui.theme.textFieldUnFocused

@Composable
fun LoginSignupComp(navController: NavController) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val screenHeight = LocalConfiguration.current.screenHeightDp
    if(screenWidth<400){

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(mainBGC)
                .padding(17.dp)
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Sign in to continue",
                    letterSpacing = 0.7.sp,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(1000),
                    color = Color.White
                )
                Text(
                    modifier = Modifier.clickable { navController.navigate("mainPage") },
                    text = "Skip",
                    fontSize = 15.sp,
                    fontWeight = FontWeight(700),
                    style = TextStyle(
                        brush = Brush.horizontalGradient(
                            colors = listOf(navBrush1, navBrush2)
                        )
                    )
                )
            }
            Spacer(modifier = Modifier.height(25.dp))

            Column {
                var enteredEmail by remember {
                    mutableStateOf("")
                }
                var enteredPassword by remember {
                    mutableStateOf("")
                }
                TextField(
                    value = enteredEmail,
                    onValueChange = { new -> enteredEmail = new },
                    maxLines = 1,
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = textFieldUnFocused,
                        focusedContainerColor = popupInnerSectionColor,
                        unfocusedLabelColor = mainFontColor,
                        focusedLabelColor = mainFontColor,
                        unfocusedTextColor = mainFontColor,
                        focusedTextColor = mainFontColor,
                        focusedIndicatorColor = mainFontColor,
                        cursorColor = mainFontColor,
                        focusedLeadingIconColor = mainFontColor,
                        unfocusedLeadingIconColor = mainFontColor,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Lock,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(top = 10.dp),
                    shape = RoundedCornerShape(5.dp)

                )


                TextField(
                    value = enteredPassword,
                    onValueChange = { new -> enteredPassword = new },
                    maxLines = 1,
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = textFieldUnFocused,
                        focusedContainerColor = popupInnerSectionColor,
                        unfocusedLabelColor = mainFontColor,
                        focusedLabelColor = mainFontColor,
                        unfocusedTextColor = mainFontColor,
                        focusedTextColor = mainFontColor,
                        focusedIndicatorColor = mainFontColor,
                        cursorColor = mainFontColor,
                        focusedLeadingIconColor = mainFontColor,
                        unfocusedLeadingIconColor = mainFontColor,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.MailOutline,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(top = 10.dp),
                    shape = RoundedCornerShape(5.dp)

                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    val isCheck = remember { mutableStateOf(false) }
                    Row {
                        Card(
                            shape = RoundedCornerShape(100),
                            border = BorderStroke(
                                2.dp,
                                color = if (isCheck.value) redFontColor else mainFontColor
                            )
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(20.dp)
                                    .background(if (isCheck.value) redFontColor else mainBGC)
                                    .clickable {
                                        isCheck.value = !isCheck.value
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                if (isCheck.value)
                                    Icon(
                                        Icons.Default.Check,
                                        contentDescription = "",
                                        tint = Color.White
                                    )
                            }
                        }

                        Text(
                            modifier = Modifier
                                .padding(start = 7.dp),
                            text = "Remember Me",
                            letterSpacing = 0.7.sp,
                            fontSize = 14.sp, fontWeight = FontWeight(400), color = mainFontColor
                        )
                    }

                }
                Text(
                    modifier = Modifier.clickable { },
                    text = "Forgot Password?",
                    letterSpacing = 0.7.sp,
                    fontSize = 14.sp, fontWeight = FontWeight(800), color = mainFontColor
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                var checkBoxStat by remember {
                    mutableStateOf(false)
                }
                Box(
                    modifier = Modifier
                        .width(20.dp)
                        .padding(0.dp), contentAlignment = Alignment.CenterStart
                ) {
                    Checkbox(colors = CheckboxDefaults.colors(
                        checkedColor = redFontColor,
                        checkmarkColor = mainFontColor,
                        uncheckedColor = mainFontColor
                    ),
                        modifier = Modifier.size(24.dp),
                        checked = checkBoxStat,
                        onCheckedChange = { checkBoxStat = if (checkBoxStat) false else true })
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(start = 5.dp), contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = buildAnnotatedString {

                            withStyle(
                                style = SpanStyle(
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight(400),
                                    letterSpacing = 1.sp,
                                    color = mainFontColor
                                )
                            ) {
                                append("By Signing in you accept ")
                            }

                            withStyle(
                                style = SpanStyle(
                                    fontSize = 13.sp,
                                    letterSpacing = 1.sp,
                                    fontWeight = FontWeight(400),
                                    color = redFontColor
                                )
                            ) {
                                append("Terms ")
                            }

                            withStyle(
                                style = SpanStyle(
                                    letterSpacing = 1.sp,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight(400),
                                    color = mainFontColor
                                )
                            ) {
                                append("and ")
                            }

                            withStyle(
                                style = SpanStyle(
                                    letterSpacing = 1.sp,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight(400),
                                    color = redFontColor
                                )
                            ) {
                                append("Privacy Policy")
                            }


                        },
                    )
                }
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp))
            //login btn
            Button(
                onClick = { navController.navigate("mainPage") },
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
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues(start = 10.dp)
            ) {
                Text(
                    text = "LOGIN", textAlign = TextAlign.Center,
                    color = mainFontColor,
                    fontSize = 17.sp,
                    letterSpacing = 1.sp,
                    fontWeight = FontWeight(600)
                )
            }

            // or continue
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp), contentAlignment = Alignment.Center){
                Text(text = "Or Continue with", letterSpacing = 1.sp, fontSize = 16.sp, fontWeight = FontWeight(500),color= mainFontColor)
            }
            //f/g btns
            Spacer(modifier = Modifier.height(20.dp))
            Row (Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                Row(modifier = Modifier
                    .fillMaxWidth(0.47f)
                    .clickable { }
                    .height(49.dp)
                    .clip(RoundedCornerShape(4.dp))){
                    Box(modifier = Modifier
                        .fillMaxWidth(0.25f)
                        .fillMaxHeight()
                        .background(faceBookColorDarker), contentAlignment = Alignment.Center){
                        Text(text = "f", fontWeight = FontWeight(1000), fontSize = 20.sp, color = mainFontColor)
                    }

                    Box(modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .background(faceBookColorLighter), contentAlignment = Alignment.Center){
                        Text(text = "Facebook", fontWeight = FontWeight(400), fontSize = 18.sp, color = mainFontColor)
                    }

                }

                Row(modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .clickable { }
                    .height(49.dp)
                    .clip(RoundedCornerShape(4.dp))){
                    Box(modifier = Modifier
                        .fillMaxWidth(0.25f)
                        .fillMaxHeight()
                        .background(googleColorDarker), contentAlignment = Alignment.Center){
                        Text(text = "G", fontWeight = FontWeight(1000), fontSize = 20.sp, color = mainFontColor)
                    }

                    Box(modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .background(googleColorlighter), contentAlignment = Alignment.Center){
                        Text(text = "Google", fontWeight = FontWeight(400), fontSize = 18.sp, color = mainFontColor)
                    }

                }

            }
            //dont have acc
            Spacer(modifier = Modifier.height(40.dp))
            Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                    Text(text = "Don't Have an Account? ", fontSize = 15.sp, fontWeight = FontWeight(700), color = mainFontColor)
                    Text(
                        modifier = Modifier.clickable {  },
                        text = "Sign Up",
                        fontSize = 17.sp,
                        fontWeight = FontWeight(700),
                        style = TextStyle(
                            brush = Brush.horizontalGradient(
                                colors = listOf(navBrush1, navBrush2)
                            )
                        )
                    )

                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row (Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                Box(modifier = Modifier
                    .fillMaxWidth(0.3f)
                    .height(3.dp)
                    .clip(RoundedCornerShape(100))
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(navBrush1, navBrush2)
                        )
                    ))
            }
            //eof
        }
    }

    if(screenWidth>400){

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(mainBGC)
                .padding(20.dp)
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Sign in to continue",
                    letterSpacing = 0.7.sp,
                    fontSize = 23.sp,
                    fontWeight = FontWeight(1000),
                    color = Color.White
                )
                Text(
                    modifier = Modifier.clickable { navController.navigate("mainPage") },
                    text = "Skip",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    style = TextStyle(
                        brush = Brush.horizontalGradient(
                            colors = listOf(navBrush1, navBrush2)
                        )
                    )
                )
            }
            Spacer(modifier = Modifier.height(30.dp))

            Column {
                var enteredEmail by remember {
                    mutableStateOf("")
                }
                var enteredPassword by remember {
                    mutableStateOf("")
                }
                TextField(
                    value = enteredEmail,
                    onValueChange = { new -> enteredEmail = new },
                    maxLines = 1,
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = textFieldUnFocused,
                        focusedContainerColor = popupInnerSectionColor,
                        unfocusedLabelColor = mainFontColor,
                        focusedLabelColor = mainFontColor,
                        unfocusedTextColor = mainFontColor,
                        focusedTextColor = mainFontColor,
                        focusedIndicatorColor = mainFontColor,
                        cursorColor = mainFontColor,
                        focusedLeadingIconColor = mainFontColor,
                        unfocusedLeadingIconColor = mainFontColor,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Lock,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(65.dp)
                        .padding(top = 10.dp),
                    shape = RoundedCornerShape(5.dp)

                )


                TextField(
                    value = enteredPassword,
                    onValueChange = { new -> enteredPassword = new },
                    maxLines = 1,
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = textFieldUnFocused,
                        focusedContainerColor = popupInnerSectionColor,
                        unfocusedLabelColor = mainFontColor,
                        focusedLabelColor = mainFontColor,
                        unfocusedTextColor = mainFontColor,
                        focusedTextColor = mainFontColor,
                        focusedIndicatorColor = mainFontColor,
                        cursorColor = mainFontColor,
                        focusedLeadingIconColor = mainFontColor,
                        unfocusedLeadingIconColor = mainFontColor,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.MailOutline,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(65.dp)
                        .padding(top = 15.dp),
                    shape = RoundedCornerShape(5.dp)

                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    val isCheck = remember { mutableStateOf(false) }
                    Row {
                        Card(
                            shape = RoundedCornerShape(100),
                            border = BorderStroke(
                                2.dp,
                                color = if (isCheck.value) redFontColor else mainFontColor
                            )
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(20.dp)
                                    .background(if (isCheck.value) redFontColor else mainBGC)
                                    .clickable {
                                        isCheck.value = !isCheck.value
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                if (isCheck.value)
                                    Icon(
                                        Icons.Default.Check,
                                        contentDescription = "",
                                        tint = Color.White
                                    )
                            }
                        }

                        Text(
                            modifier = Modifier
                                .padding(start = 12.dp),
                            text = "Remember Me",
                            letterSpacing = 0.7.sp,
                            fontSize = 16.sp, fontWeight = FontWeight(400), color = mainFontColor
                        )
                    }

                }
                Text(
                    modifier = Modifier.clickable { },
                    text = "Forgot Password?",
                    letterSpacing = 0.7.sp,
                    fontSize = 16.sp, fontWeight = FontWeight(800), color = mainFontColor
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                var checkBoxStat by remember {
                    mutableStateOf(false)
                }
                Box(
                    modifier = Modifier
                        .width(20.dp)
                        .padding(0.dp), contentAlignment = Alignment.CenterStart
                ) {
                    Checkbox(colors = CheckboxDefaults.colors(
                        checkedColor = redFontColor,
                        checkmarkColor = mainFontColor,
                        uncheckedColor = mainFontColor
                    ),
                        modifier = Modifier.size(24.dp),
                        checked = checkBoxStat,
                        onCheckedChange = { checkBoxStat = if (checkBoxStat) false else true })
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(start = 12.dp), contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = buildAnnotatedString {

                            withStyle(
                                style = SpanStyle(
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight(400),
                                    letterSpacing = 1.sp,
                                    color = mainFontColor
                                )
                            ) {
                                append("By Signing in you accept ")
                            }

                            withStyle(
                                style = SpanStyle(
                                    fontSize = 15.sp,
                                    letterSpacing = 1.sp,
                                    fontWeight = FontWeight(400),
                                    color = redFontColor
                                )
                            ) {
                                append("Terms ")
                            }

                            withStyle(
                                style = SpanStyle(
                                    letterSpacing = 1.sp,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight(400),
                                    color = mainFontColor
                                )
                            ) {
                                append("and ")
                            }

                            withStyle(
                                style = SpanStyle(
                                    letterSpacing = 1.sp,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight(400),
                                    color = redFontColor
                                )
                            ) {
                                append("Privacy Policy")
                            }


                        },
                    )
                }
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(30.dp))
            //login btn
            Button(
                onClick = { navController.navigate("mainPage") },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp))
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(navBrush1, navBrush2)
                        )
                    )
                    .height(52.dp),
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues(start = 10.dp)
            ) {
                Text(
                    text = "LOGIN", textAlign = TextAlign.Center,
                    color = mainFontColor,
                    fontSize = 20.sp,
                    letterSpacing = 1.sp,
                    fontWeight = FontWeight(600)
                )
            }

            // or continue
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp), contentAlignment = Alignment.Center){
                Text(text = "Or Continue with", letterSpacing = 1.sp, fontSize = 16.sp, fontWeight = FontWeight(500),color= mainFontColor)
            }
            //f/g btns
            Spacer(modifier = Modifier.height(25.dp))
            Row (Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                Row(modifier = Modifier
                    .fillMaxWidth(0.47f)
                    .clickable { }
                    .height(53.dp)
                    .clip(RoundedCornerShape(4.dp))){
                    Box(modifier = Modifier
                        .fillMaxWidth(0.25f)
                        .fillMaxHeight()
                        .background(faceBookColorDarker), contentAlignment = Alignment.Center){
                        Text(text = "f", fontWeight = FontWeight(1000), fontSize = 22.sp, color = mainFontColor)
                    }

                    Box(modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .background(faceBookColorLighter), contentAlignment = Alignment.Center){
                        Text(text = "Facebook", fontWeight = FontWeight(400), fontSize = 20.sp, color = mainFontColor)
                    }

                }

                Row(modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .clickable { }
                    .height(53.dp)
                    .clip(RoundedCornerShape(4.dp))){
                    Box(modifier = Modifier
                        .fillMaxWidth(0.25f)
                        .fillMaxHeight()
                        .background(googleColorDarker), contentAlignment = Alignment.Center){
                        Text(text = "G", fontWeight = FontWeight(1000), fontSize = 22.sp, color = mainFontColor)
                    }

                    Box(modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .background(googleColorlighter), contentAlignment = Alignment.Center){
                        Text(text = "Google", fontWeight = FontWeight(400), fontSize = 20.sp, color = mainFontColor)
                    }

                }

            }
            //dont have acc
            Spacer(modifier = Modifier.height(40.dp))
            Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                    Text(text = "Don't Have an Account? ", fontSize = 18.sp, fontWeight = FontWeight(700), color = mainFontColor)
                    Text(
                        modifier = Modifier.clickable {  },
                        text = "Sign Up",
                        fontSize = 19.sp,
                        fontWeight = FontWeight(700),
                        style = TextStyle(
                            brush = Brush.horizontalGradient(
                                colors = listOf(navBrush1, navBrush2)
                            )
                        )
                    )

                }
            }
            Spacer(modifier = Modifier.height(17.dp))
            Row (Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                Box(modifier = Modifier
                    .fillMaxWidth(0.33f)
                    .height(3.dp)
                    .clip(RoundedCornerShape(100))
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(navBrush1, navBrush2)
                        )
                    ))
            }
            //eof
        }
    }

}
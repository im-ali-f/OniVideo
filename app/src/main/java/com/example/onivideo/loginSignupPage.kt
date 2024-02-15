package com.example.onivideo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onivideo.ui.theme.mainBGC
import com.example.onivideo.ui.theme.mainFontColor
import com.example.onivideo.ui.theme.navBrush1
import com.example.onivideo.ui.theme.navBrush2
import com.example.onivideo.ui.theme.popupInnerSectionColor
import com.example.onivideo.ui.theme.radioButtonColor
import com.example.onivideo.ui.theme.radioSelectedColor
import com.example.onivideo.ui.theme.redFontColor
import com.example.onivideo.ui.theme.switchThumbColor
import com.example.onivideo.ui.theme.switchTrackColor
import com.example.onivideo.ui.theme.textFieldUnFocused

@Composable
fun LoginSignupComp(navController: NavController) {
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
    }
}
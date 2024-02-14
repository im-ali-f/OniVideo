package com.example.onivideo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material.icons.twotone.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onivideo.ui.theme.mainBGC
import com.example.onivideo.ui.theme.mainFontColor
import com.example.onivideo.ui.theme.scaffoldHeadalphaColor
import com.example.onivideo.ui.theme.scaffoldSelectedBGCColor
import com.example.onivideo.ui.theme.scaffoldSelectedColor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.Black),
        contentAlignment = Alignment.Center
    )

    {
        Row(
            modifier = Modifier
                .padding(start = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(contentAlignment = Alignment.Center) {
                Box(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(100))
                        .background(
                            scaffoldHeadalphaColor
                        )
                        .size(55.dp)
                )
                Box(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(100))
                        .background(
                            Color.White
                        )
                        .size(48.dp)
                )

            }

            Column(
                modifier = Modifier
                    .padding(start = 5.dp)
                    .width(130.dp)
                    .fillMaxHeight(), verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Ali",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = Color.White
                )
                Text(
                    text = "alifarhad.work@gmail.com",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    color = mainFontColor
                )
            }

            Icon(
                modifier = Modifier.padding(start = 10.dp),
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                tint = Color.White
            )

        }

    }
}

@Composable
fun DrawerBody(navController: NavController, scaffoldState: ScaffoldState,scope : CoroutineScope,active:MutableState<String>) {
    val BTNlist = listOf<String>(
        "Home",
        "TV Shows",
        "Movies",
        "Sports",
        "Live TV",
        "Watchlist",
        "Dashboard",
        "Profile",
        "Settings",
        "Logout"
    )
    val helperMap= mapOf(
        "Home" to "mainPage",
        "TV Shows" to "mainPage",//change
        "Movies" to "mainPage",//change
        "Sports" to "mainPage",//change
        "Live TV" to "mainPage",//change
        "Watchlist" to "watchlistPage",
        "Dashboard" to "dashboardPage",//change
        "Profile" to "accountPage",
        "Settings" to "settingPage",
        "Logout" to "mainPage"//change
    )
    val helperMapIcon= mapOf<String,Int>(
        "Home" to R.drawable.mainpage,
        "TV Shows" to R.drawable.tvpage,//change
        "Movies" to R.drawable.moviepage,//change
        "Sports" to R.drawable.sportpage,//change
        "Live TV" to R.drawable.livepage,//change
        "Watchlist" to R.drawable.list,
        "Dashboard" to R.drawable.dashboardpage,//change
        "Profile" to R.drawable.profilepage,
        "Settings" to R.drawable.settingpage,
        "Logout" to R.drawable.logout//change
    )
    var activeBTN =active

    var scrollState = rememberScrollState()
    Column(modifier = Modifier
        // .background(Color.Red)
        .padding(top = 10.dp)
        .fillMaxHeight()
        .verticalScroll(scrollState)
    ) {

        BTNlist.forEach(){
            BTN->
            var BGCColor = if (activeBTN.value == BTN) scaffoldSelectedBGCColor else mainBGC
            val nav= ""+helperMap[BTN]
            var icon = helperMapIcon[BTN]
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(start = 10.dp)
                    .clip(RoundedCornerShape(100, 0, 0, 100))
                    .background(BGCColor)
                    .clickable {
                        navController.navigate(nav)
                        activeBTN.value = BTN
                        //mishe ino hazf kard
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }

                    }, verticalAlignment = Alignment.CenterVertically
            )
            {
                var IconColor = if (activeBTN.value == BTN) scaffoldSelectedColor else Color.White
                Icon(
                    modifier = Modifier.padding(start = 10.dp),
                    painter = painterResource(icon as Int),
                    contentDescription = null,
                    tint = IconColor
                )
                Spacer(modifier = Modifier.width(13.dp))
                Text(
                    text = BTN,
                    modifier = Modifier.weight(1f),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700),
                    color = IconColor
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
        }







    }

}
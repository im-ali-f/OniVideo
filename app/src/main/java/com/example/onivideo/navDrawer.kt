package com.example.onivideo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DrawerHeader() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 64.dp),
        contentAlignment = Alignment.Center){
        Text(text = "Header", fontSize = 60.sp)
    }
}

@Composable
fun DrawerBody(){

    Column {
        Row (
            Modifier
                .fillMaxWidth()
                .clickable { }
                .padding(16.dp)){
            Icon(imageVector = Icons.TwoTone.Home, contentDescription = null)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Home page", modifier = Modifier.weight(1f))
        }
    }

}
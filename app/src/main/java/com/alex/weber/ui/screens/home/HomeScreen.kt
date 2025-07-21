package com.alex.weber.ui.screens.home


import android.Manifest
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.weber.R


@Composable
fun Homescreen(
    innerPadding:   PaddingValues
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(Color.Black)
    ){
// main video area
        Image(
            painter = painterResource(R.drawable.t),
            contentDescription = "Users video",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
//        Top bar with logo
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.TopCenter),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
Row (verticalAlignment = Alignment.CenterVertically){
    Icon(
        painter = painterResource(R.drawable._logo),
        contentDescription = "App logo",
        tint = Color.White,
        modifier = Modifier.size(24.dp)
    )
    Spacer(modifier = Modifier.width(8.dp))
    Text(
        "Weber",
        color = Color.White,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}
            Row {
                Icon(Icons.Default.Notifications,  contentDescription = "Notification", tint = Color.White)
            Spacer(modifier = Modifier.width(12.dp))
                Icon(Icons.Default.Settings,  contentDescription = "Settings", tint = Color.White)
            }
        }
        // Right- side buttons
        Column (
            modifier = Modifier
                .padding(end = 16.dp)
                .align(Alignment.CenterEnd).fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            IconButton(onClick = {}) {
                Icon(Icons.Default.FavoriteBorder, contentDescription = "Like Button", tint = Color.White)
            }
            IconButton(onClick = {}) {
                Icon(Icons.Default.Share, contentDescription = "Share Button", tint = Color.White)
            }
            IconButton(onClick = {}) {
                Icon(Icons.Default.Person, contentDescription = "Profile Button", tint = Color.White)
            }
        }
//        users info
        Text(
            text = "User's Info...",
            color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        )
//        Bottom navigation


    }
}
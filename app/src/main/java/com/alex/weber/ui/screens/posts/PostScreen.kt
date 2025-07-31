package com.alex.weber.ui.screens.posts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.Cameraswitch
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.weber.R
import com.alex.weber.ui.theme.GreenJC
import com.alex.weber.ui.theme.sportOrange

@Composable
fun Post(innerPadding : PaddingValues) {
    // Post top
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp, horizontal = 12.dp)){

            Icon(imageVector = Icons.Default.Cameraswitch, contentDescription = "camera")
            Icon(imageVector = Icons.Default.AcUnit, contentDescription = "Acunit")
    }
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(Color.White),
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Post", fontSize = 30.sp, color = GreenJC)
        }


//     Right side interraction buttons
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .padding(end = 16.dp, bottom = 80.dp),



        ) {
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(R.drawable.edit),
                    contentDescription = "edit",
                    tint = Color.Black,
                    modifier = Modifier.size(32.dp)
                )
            }
            Spacer(modifier = Modifier.size(8.dp))

            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(R.drawable.trim),
                    contentDescription = "Trim",
                    tint = Color.Black,
                    modifier = Modifier.size(32.dp)
                )
            }
            Spacer(modifier = Modifier.size(8.dp))

            Image(
                painter = painterResource(id = R.drawable.emoji),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Black, CircleShape).clickable(onClick = { })
                    .padding(vertical = 10.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.PhotoCamera, contentDescription = "Camera")
            }

            Button(
                onClick = {},
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier.defaultMinSize(minWidth = 80.dp)
            ) {
                Text("Post")
            }

            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.PhotoLibrary,
                    contentDescription = "Gallery"
                )
            }
        }

    }
    }

@Composable
fun PostItems(
    onCameraClick: () -> Unit,
    onPostClick: () -> Unit,
    onGalleryClick: () -> Unit,
    innerPadding: PaddingValues
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 24.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onCameraClick) {
                Icon(imageVector = Icons.Default.PhotoCamera, contentDescription = "Camera")
            }

            Button(
                onClick = onPostClick,
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier.defaultMinSize(minWidth = 80.dp)
            ) {
                Text("Post")
            }

            IconButton(onClick = onGalleryClick) {
                Icon(
                    imageVector = Icons.Default.PhotoLibrary,
                    contentDescription = "Gallery"
                )
            }
        }
    }
}







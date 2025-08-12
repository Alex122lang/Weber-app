package com.alex.weber.ui.screens.posts

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.webkit.MimeTypeMap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alex.weber.R
import com.alex.weber.ui.screens.home.HomeViewModel
import com.alex.weber.ui.theme.GreenJC

@Composable
fun Post(innerPadding : PaddingValues, homeViewModel: HomeViewModel = viewModel()) {
    val context = LocalContext.current
        fun getFileNameFromUri(context: Context, uri: Uri): String? {
            val cursor = context.contentResolver.query(uri, null, null, null, null)
            return cursor?.use {
                val nameIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                if (it.moveToFirst() && nameIndex != -1) {
                    it.getString(nameIndex)
                } else null
            }
        }

        //  get mime type
        fun getExtensionFromUri(context: Context, uri: Uri): String? {
            val mimeType = context.contentResolver.getType(uri)
            return MimeTypeMap.getSingleton().getExtensionFromMimeType(mimeType)
        }


// Activity result launcher for picking a file
        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.StartActivityForResult()
        ) { result ->
            val uri = result.data?.data
            if (uri != null) {
                val inputStream = context.contentResolver.openInputStream(uri)
                val fileBytes = inputStream?.readBytes()
                val fileName = getFileNameFromUri(context, uri) ?: "upload.${getExtensionFromUri(context, uri) ?: "dat"}"

                if (fileBytes != null) {
                homeViewModel.insertImage(fileName, fileBytes)
                }
            }
        }
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val uri = result.data?.data
        if (uri != null) {
            val inputStream = context.contentResolver.openInputStream(uri)
            val fileBytes = inputStream?.readBytes()
            val fileName = "capture_${System.currentTimeMillis()}.mp4" // works for photo/video
            if (fileBytes != null) {
                homeViewModel.insertImage(fileName, fileBytes)
            }
        }
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
            IconButton(onClick = {
                val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE) // Can switch to ACTION_IMAGE_CAPTURE
                cameraLauncher.launch(intent)

            }) {
                Icon(imageVector = Icons.Default.PhotoCamera, contentDescription = "Camera")
            }

            Button(
                onClick = {

                    val result = homeViewModel.createPosts("Product", "client product")
                },
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier.defaultMinSize(minWidth = 80.dp)
            ) {
                Text("Post")
            }

            IconButton(onClick = {
                val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                    type = "*/*" // or "image/*" or "video/*"
                    addCategory(Intent.CATEGORY_OPENABLE)
                }

                launcher.launch(intent)

            }) {
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
    onPostClick: () -> Unit,
    onGalleryClick: () -> Unit,
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
            IconButton(onClick = {}) {
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







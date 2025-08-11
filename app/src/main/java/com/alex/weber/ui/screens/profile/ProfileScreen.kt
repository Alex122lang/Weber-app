package com.alex.weber.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.weber.R
import com.alex.weber.ui.theme.sportOrange


@Composable
fun Profile(){

    // State holders for each field — can be replaced with ViewModel or user data
    var name by remember { mutableStateOf("Jane Wanjiku") }
    var about by remember { mutableStateOf("Design thinker | Kotlin dev") }
    var phone by remember { mutableStateOf("+254700987654") }

    // Track selected content type
    var selectedTab by remember { mutableStateOf("Images") }

    // Example data
    val imagePosts = listOf(R.drawable.person, R.drawable.person) // Replace with your images
    val videoPosts = listOf("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
        "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4") // Replace with your video URIsc

    val scrollState = rememberScrollState()




    Column(
    modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState) // 👈 makes it scrollable
        .padding(24.dp),
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Text(text = "Profile")
//    profile picture
    Image(
        modifier = Modifier
            .size(120.dp)
            .clip(CircleShape)
            .border(2.dp, sportOrange, CircleShape),
        painter = painterResource(R.drawable.person),
        contentDescription = "User profile"
    )
    Spacer(modifier = Modifier.height(32.dp))

//    Name field
    OutlinedTextField(
        value = "Alex Kinyanjui",
        onValueChange = {
            ""

        },
        label = { Text(text = "Name")},
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(22.dp))

//    About field
    OutlinedTextField(
        value = "Software Developer",
        onValueChange = {
            ""
        },
        label = { Text(text = "About")},
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(22.dp))

    //    Phone Number
    OutlinedTextField(
        value = "+25476802895809",
        onValueChange = {
            ""

        },
        label = { Text(text = "Phone Number")},
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
    )
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ){
        Row (){
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = "Location icon",
                tint = sportOrange,
//                navigate to the map
                modifier = Modifier.size(24.dp).clickable(onClick = {  })
            )
        }
        Icon(
            painter = painterResource(R.drawable.chat),
            contentDescription = "Chat icon",
            tint = sportOrange,

            //                navigate to the chats
            modifier = Modifier.size(24.dp).clickable(onClick = {  })
        )
    }
        Spacer(modifier = Modifier.height(16.dp))

        // Toggle buttons
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            androidx.compose.material3.Button(
                onClick = { selectedTab = "Images" },
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = if (selectedTab == "Images") sportOrange else androidx.compose.material3.MaterialTheme.colorScheme.surface
                )
            ) {
                Text("Images", color = if (selectedTab == "Images") androidx.compose.material3.MaterialTheme.colorScheme.onPrimary else sportOrange)
            }

            androidx.compose.material3.Button(
                onClick = { selectedTab = "Videos" },
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = if (selectedTab == "Videos") sportOrange else androidx.compose.material3.MaterialTheme.colorScheme.surface
                )
            ) {
                Text("Videos", color = if (selectedTab == "Videos") androidx.compose.material3.MaterialTheme.colorScheme.onPrimary else sportOrange)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Conditional content
        if (selectedTab == "Images") {
            ImageGrid(images = imagePosts)
        } else {
            VideoList(videos = videoPosts)
        }
    }
}

@Composable
fun ImageGrid(images: List<Int>) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        images.forEach { resId ->
            Image(
                painter = painterResource(id = resId),
                contentDescription = "Posted image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
            )
        }
    }
}

@Composable
fun VideoList(videos: List<String>) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        videos.forEach { videoPath ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .border(1.dp, sportOrange, androidx.compose.foundation.shape.RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text("Video: $videoPath", fontSize = 14.sp)
            }
        }
}
}
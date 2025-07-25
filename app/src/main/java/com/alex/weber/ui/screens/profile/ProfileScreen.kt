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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
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
//    Box(modifier = Modifier.fillMaxSize()){
//        Column (modifier = Modifier
//            .fillMaxSize()
//            .align(Alignment.Center),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally){
//            Text(text = "Profile", fontSize = 30.sp, color = GreenJC)
//        }
//    }

    // State holders for each field — can be replaced with ViewModel or user data
    var name by remember { mutableStateOf("Jane Wanjiku") }
    var about by remember { mutableStateOf("Design thinker | Kotlin dev") }
    var phone by remember { mutableStateOf("+254700987654") }


    Column(
    modifier = Modifier
        .fillMaxSize()
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

        },
        label = { Text(text = "Name")},
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(22.dp))

//    About field
    OutlinedTextField(
        value = "Software Developer",
        onValueChange = {

        },
        label = { Text(text = "About")},
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(22.dp))

    //    Phone Number
    OutlinedTextField(
        value = "+25476802895809",
        onValueChange = {

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
//                navigate to the map
                modifier = Modifier.size(24.dp).clickable(onClick = {  })
            )
        }
        Icon(
            painter = painterResource(R.drawable.chat),
            contentDescription = "Chat icon",
            //                navigate to the chats
            modifier = Modifier.size(24.dp).clickable(onClick = {  })
        )
    }
}
}
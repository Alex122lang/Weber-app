package com.alex.weber.ui.screens.chats


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.weber.R
import com.alex.weber.ui.theme.GreenJC

@Composable
fun Chats(innerPadding : PaddingValues) {
//    Box(modifier = Modifier.fillMaxSize()){
//        Column (modifier = Modifier
//            .fillMaxSize()
//            .align(Alignment.Center),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally){
//            Text(text = "Chats", fontSize = 30.sp, color = GreenJC)
//        }
//    }


    Column(
        modifier = Modifier
            .fillMaxHeight()
        .padding(innerPadding),
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "chats",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            )

        UserChatItem(chat = "jjjggjkgjjjggjkgjjjggjkgjjjggjkgjjjggjkgjjjggjkgjjjggjkg", uid = "1")
        UserChatItem(chat = "jjjggjkgjjjggjkgjjjggjkgjjjggjkgjjjggjkgjjjggjkgjjjggjkg", uid = "1")
        UserChatItem(chat = "jjjggjkgjjjggjkgjjjggjkgjjjggjkgjjjggjkgjjjggjkgjjjggjkg", uid = "1")
        UserChatItem(chat = "jjjggjkgjjjggjkgjjjggjkgjjjggjkgjjjggjkgjjjggjkgjjjggjkg", uid = "1")
        UserChatItem(chat = "jjjggjkgjjjggjkgjjjggjkgjjjggjkgjjjggjkgjjjggjkgjjjggjkg", uid = "1")
        UserChatItem(chat = stringResource(R.string.dummy_text).toString(), uid = "1")
        UserChatItem(chat = "jjjggjkgjjjggjkgjjjggjkgjjjggjkgjjjggjkgjjjggjkgjjjggjkg", uid = "1")
        UserChatItem(chat = "jjjggjkgjjjggjkgjjjggjkgjjjggjkgjjjggjkgjjjggjkgjjjggjkg", uid = "1")


    }
}

@Composable
private fun UserChatItem(chat: String, uid: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            modifier = Modifier
                .clip(CircleShape)
                .size(48.dp)
                .background(Color.LightGray),
            tint = Color.Black,
            contentDescription = "Profile icon"
        )
        Text(
            text = chat,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontSize = 12.sp,
            fontWeight = FontWeight.Light,
            color = Color.Gray
        )
    }
}


package com.alex.weber.ui.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.weber.R
import com.alex.weber.ui.theme.GreenJC
import com.alex.weber.ui.theme.sportOrange
import java.time.format.TextStyle

@Composable
fun Search(innerPadding: PaddingValues) {
    // states
    var searchInput by remember {
        mutableStateOf("")
    }
        Column(
            modifier = Modifier
                .fillMaxSize().padding(innerPadding),
             verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Search", fontSize = 30.sp, color = GreenJC)
            TextField(
                value = searchInput,
                onValueChange = { newValue ->
                    searchInput = newValue
                },

                placeholder = { Text(text = "Connect with the others") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    errorContainerColor = Color.Red,
                    unfocusedIndicatorColor = Color.LightGray,
                    focusedLeadingIconColor = sportOrange,
                    unfocusedLeadingIconColor = Color.LightGray
                ),
                leadingIcon =
                    {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search icon",
                            tint = sportOrange,
                        )
                    }
            )

    }
}
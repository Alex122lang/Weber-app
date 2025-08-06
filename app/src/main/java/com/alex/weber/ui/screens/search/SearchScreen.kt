@file:OptIn(ExperimentalMaterial3Api::class)

package com.alex.weber.ui.screens.search

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Search(innerPadding: PaddingValues) {
    // states
    var searchInput by remember {
       mutableStateOf("")
   }
    var text by remember { mutableStateOf("")}
    var active by remember { mutableStateOf(false)}
    var items = remember {
        mutableListOf(
            "Kotlin programming",
            "Laptops for sale"

        )
    }
    Scaffold {
        SearchBar (
            modifier = Modifier.fillMaxWidth(),
            query = text,
            onQueryChange = {
                text = it
            },
            onSearch = {
                items.add(text)
                active = false
                text = ""
            },
            active = active,
            onActiveChange = {
                active = it
            },
            placeholder = {
                Text(text = "Search")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "search icon")
            },
            trailingIcon = {
                if (active){
                    Icon(
                        modifier = Modifier.clickable{
                            if (text.isNotEmpty()){
                                text = ""
                            }else{
                                active = false
                            }
                        },
                        imageVector = Icons.Default.Close,
                        contentDescription = "close icon"


                    )
                }

            }
        ) {
            items.forEach {
                Row (modifier = Modifier.padding(all = 14.dp)){
                    Icon(
                        modifier = Modifier.padding(end = 10.dp),
                        imageVector = Icons.Default.History,
                        contentDescription = "History Icon"
                    )
                    Text(text = it)
                }
            }
        }
    }

}
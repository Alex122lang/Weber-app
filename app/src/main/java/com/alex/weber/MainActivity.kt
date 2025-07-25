package com.alex.weber

import Home
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.alex.weber.ui.models.Screens
import com.alex.weber.ui.screens.Settings
import com.alex.weber.ui.screens.chats.Chats
import com.alex.weber.ui.screens.notifications.Notification
import com.alex.weber.ui.screens.posts.Post
import com.alex.weber.ui.screens.profile.Profile
import com.alex.weber.ui.screens.search.Search
import com.alex.weber.ui.theme.GreenJC
import com.alex.weber.ui.theme.WeberTheme
import com.alex.weber.ui.theme.sportOrange
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeberTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    //topBar = { TopAppBar() },
                ) { innerPadding ->
//                    TopAppBar()
                    NavBotSheet(innerPadding)
                }
            }
        }
    }
}

// Top Bar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(){

    val context = LocalContext.current.applicationContext

    TopAppBar(title = { Text(text = "Weber")},
        navigationIcon = {
            IconButton(onClick = { Toast.makeText(context, "Weber", Toast.LENGTH_SHORT).show() }) {
                Icon(painter = painterResource(id = R.drawable._logo, ), contentDescription = "Whatsapp icon", tint = sportOrange)
            }
        }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.LightGray,
            titleContentColor = sportOrange,
            navigationIconContentColor = Color.White
        ), actions = {
            IconButton(onClick = { Toast.makeText(context, "Notification", Toast.LENGTH_SHORT).show() })  {
                Icon(imageVector = Icons.Filled.Notifications, contentDescription = "notification icon",)
            }
            IconButton(onClick = { Toast.makeText(context, "Settings", Toast.LENGTH_SHORT).show() })  {
                Icon(painter = painterResource(R.drawable.settings), contentDescription = "settings icon", )
            }

        }
        )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavBotSheet(innerPadding: PaddingValues){
    val navigationController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val context = LocalContext.current.applicationContext

    val selected = remember{
        mutableStateOf(Icons.Default.Home)
    }

    val SheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember {
        mutableStateOf(value = false)
    }
    var topBarState by remember {
        mutableStateOf(value = false)
    }

    val navBarNavBackStackEntry by navigationController.currentBackStackEntryAsState()


    Scaffold(
        topBar = {
            when(navBarNavBackStackEntry?.destination?.route){
                Screens.Home.screen -> {topBarState = true}
                else -> {topBarState = false}
            }
            AnimatedVisibility(
                visible = topBarState,
                enter = slideInVertically(initialOffsetY = {it}),
                        exit = slideOutVertically(targetOffsetY = {it}),
                content = { TopAppBar() }
            )

        },
        bottomBar = {
            BottomAppBar (containerColor = Color.White){
                IconButton(onClick = {
                    selected.value = Icons.Default.Home
                    navigationController.navigate(Screens.Home.screen){
                        popUpTo(0)
                    }
                }, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Home, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Home) sportOrange else Color.DarkGray)
                }
                IconButton(onClick = {
                    selected.value = Icons.Default.Search
                    navigationController.navigate(Screens.Search.screen){
                        popUpTo(0)
                    }
                }, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Search, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Search) sportOrange else Color.DarkGray)
                }

                Box(modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                contentAlignment = Alignment.Center){
                    FloatingActionButton(onClick = { showBottomSheet = true }) {
                        Icon(Icons.Default.Add, contentDescription = null, tint = GreenJC)
                    }

                }
// REMEMBER TO CHANGE THE LOGO DJCJJFKFKKKKF
                IconButton(onClick = {
                    selected.value = Icons.Default.Email
                    navigationController.navigate(Screens.Chats.screen){
                        popUpTo(0)
                    }
                }, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Email, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Email) sportOrange else Color.DarkGray)

                }

                IconButton(onClick = {
                    selected.value = Icons.Default.Person
                    navigationController.navigate(Screens.Profile.screen){
                        popUpTo(0)
                    }
                }, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Person) sportOrange else Color.DarkGray)
                }
            }
        }
    ) {
        NavHost(navController = navigationController,
            modifier = Modifier.padding(innerPadding),
            startDestination = Screens.Home.screen){
            composable(Screens.Home.screen) { Home(innerPadding) }
            composable(Screens.Search.screen) { Search(innerPadding) }
            composable(Screens.Chats.screen) { Chats(innerPadding) }
            composable(Screens.Profile.screen) { Profile() }
            composable(Screens.Post.screen) { Post(innerPadding) }
            composable(Screens.Settings.screen) { Settings() }
            composable(Screens.Notification.screen) { Notification() }

        }
    }
        if (showBottomSheet){
            ModalBottomSheet(onDismissRequest = {showBottomSheet = false},
                sheetState = SheetState) {
                Column (modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)){


                    BottomSheetItem(icon = Icons.Default.ThumbUp, title = "Create a Post"){
                    showBottomSheet = false
                    navigationController.navigate(Screens.Post.screen)}
                }
            }
        }
    }
@Composable
fun BottomSheetItem(icon: ImageVector, title:String, onClick: () -> Unit){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.clickable { onClick ()}
    ){
        Icon(icon, contentDescription = null, tint = GreenJC)
        Text(text = title, color = GreenJC, fontSize = 22.sp)
    }
}



































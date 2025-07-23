package com.alex.weber

import Home
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
                Icon(painter = painterResource(id = R.drawable._logo, ), contentDescription = "Whatsapp icon")
            }
        }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = GreenJC,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White
        ), actions = {
            IconButton(onClick = { Toast.makeText(context, "Notification", Toast.LENGTH_SHORT).show() })  {
                Icon(imageVector = Icons.Filled.Notifications, contentDescription = "notification icon", tint = Color.White)
            }
            IconButton(onClick = { Toast.makeText(context, "Settings", Toast.LENGTH_SHORT).show() })  {
                Icon(imageVector = Icons.Filled.Settings, contentDescription = "settings icon", tint = Color.White)
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
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Box(modifier = Modifier
                    .background(GreenJC)
                    .fillMaxWidth()
                    .height(150.dp)
                ){
                    Text(text = "")
                }
                Spacer(modifier = Modifier.height(10.dp))
                NavigationDrawerItem(label = {Text(text = "Home", color = GreenJC)},
                    selected = false,
                    icon = {Icon(imageVector = Icons.Default.Home, contentDescription = "Home", tint = GreenJC)},
                    onClick = {
                        coroutineScope.launch{
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Home.screen){
//                            NEED CLALIFICATION
                            popUpTo(0)
                        }
                    } )
                NavigationDrawerItem(label = {Text(text = "Settings", color = GreenJC)},
                    selected = false,
                    icon = {Icon(imageVector = Icons.Default.LocationOn, contentDescription = "location", tint = GreenJC)},
                    onClick = {
                        coroutineScope.launch{
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Settings.screen){
                            popUpTo(0)
                        }
                    } )
                NavigationDrawerItem(label = {Text(text = "Profile", color = GreenJC)},
                    selected = false,
                    icon = {Icon(imageVector = Icons.Default.Person, contentDescription = "profile", tint = GreenJC)},
                    onClick = {
                        coroutineScope.launch{
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Profile.screen){
                            popUpTo(0)
                        }
                    } )
                NavigationDrawerItem(label = {Text(text = "Logout", color = GreenJC)},
                    selected = false,
                    icon = {Icon(imageVector = Icons.Default.Close, contentDescription = "logout", tint = GreenJC)},
                    onClick = {
                        coroutineScope.launch{
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Settings.screen){
                            popUpTo(0)
                        }
                        Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show()
                    } )
            }
        },
        ) {
    Scaffold(
        topBar = {
            TopAppBar()
        },
        bottomBar = {
            BottomAppBar (containerColor = GreenJC){
                IconButton(onClick = {
                    selected.value = Icons.Default.Home
                    navigationController.navigate(Screens.Home.screen){
                        popUpTo(0)
                    }
                }, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Home, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Home) Color.White else Color.DarkGray)
                }
                IconButton(onClick = {
                    selected.value = Icons.Default.Search
                    navigationController.navigate(Screens.Search.screen){
                        popUpTo(0)
                    }
                }, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Search, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Search) Color.White else Color.DarkGray)
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
                        tint = if (selected.value == Icons.Default.Email) Color.White else Color.DarkGray)

                }

                IconButton(onClick = {
                    selected.value = Icons.Default.Person
                    navigationController.navigate(Screens.Profile.screen){
                        popUpTo(0)
                    }
                }, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Person) Color.White else Color.DarkGray)
                }
            }
        }
    ) {
        NavHost(navController = navigationController,
            startDestination = Screens.Home.screen){
            composable(Screens.Home.screen) { Home(innerPadding) }
            composable(Screens.Search.screen) { Search() }
            composable(Screens.Chats.screen) { Chats() }
            composable(Screens.Profile.screen) { Profile() }
            composable(Screens.Post.screen) { Post() }
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
    }}
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



































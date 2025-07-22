package com.alex.weber.ui.models

sealed class Screens(val screen: String) {
    data object Home: Screens(screen = "home")
    data object Search: Screens(screen = "search")
    data object Post: Screens(screen = "posts")
    data object Chats: Screens(screen = "chats")
    data object Profile: Screens(screen = "profile")
    data object Notification: Screens(screen = "notification")
    data object Settings: Screens(screen = "settings")
}
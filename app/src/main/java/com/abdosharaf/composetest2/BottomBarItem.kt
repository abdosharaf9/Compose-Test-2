package com.abdosharaf.composetest2

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarItem(
    val route: String,
    val icon: ImageVector,
    val title: String
) {
    data object Home : BottomBarItem(
        route = "home_screen",
        icon = Icons.Default.Home,
        title = "Home"
    )

    data object Settings : BottomBarItem(
        route = "settings_screen",
        icon = Icons.Default.Settings,
        title = "Settings"
    )

    data object Profile : BottomBarItem(
        route = "profile_screen",
        icon = Icons.Default.Person,
        title = "Profile"
    )
}
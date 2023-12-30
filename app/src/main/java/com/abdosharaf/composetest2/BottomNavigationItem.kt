package com.abdosharaf.composetest2

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItem(
    val route: String,
    val name: String,
    val icon: ImageVector
) {
    data object Home: BottomNavigationItem(
        route = "home",
        name = "Home",
        icon = Icons.Default.Home
    )
    data object Profile: BottomNavigationItem(
        route = "profile",
        name = "Profile",
        icon = Icons.Default.Person
    )
    data object Settings: BottomNavigationItem(
        route = "settings",
        name = "Settings",
        icon = Icons.Default.Settings
    )
}
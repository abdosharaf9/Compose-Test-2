package com.abdosharaf.composetest2.navigation

sealed class Screen(val route: String) {
    data object Permission: Screen(route = "permission_screen")
    data object Main: Screen(route = "main_screen")
}
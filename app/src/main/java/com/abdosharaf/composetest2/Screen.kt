package com.abdosharaf.composetest2

sealed class Screen(val route: String) {
    data object Home : Screen(route = "home_screen")
    data object Detail : Screen(route = "detail_screen")
}
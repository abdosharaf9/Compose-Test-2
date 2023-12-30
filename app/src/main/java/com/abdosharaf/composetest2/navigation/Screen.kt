package com.abdosharaf.composetest2.navigation

sealed class Screen(val route: String) {
    data object Home : Screen(route = "home_screen")
    data object Detail: Screen(route = "detail_screen")
    data object Login: Screen(route = "login_screen")
    data object SignUp: Screen(route = "sign_up_screen")
}
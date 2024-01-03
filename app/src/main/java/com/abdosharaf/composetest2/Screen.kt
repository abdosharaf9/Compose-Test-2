package com.abdosharaf.composetest2

sealed class Screen(val route: String) {
    data object Login: Screen(route = "login")
    data object SignUp: Screen(route = "signup")
    data object Details: Screen(route = "details")
    data object Information: Screen(route = "information")
}
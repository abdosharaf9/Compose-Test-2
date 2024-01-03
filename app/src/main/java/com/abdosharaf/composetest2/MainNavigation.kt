package com.abdosharaf.composetest2

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupMainNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Graph.Auth.route,
        route = Graph.Root.route
    ) {
        authNavigation(navController)
        composable(route = Graph.Home.route) {
            HomeScreen()
        }
    }
}
package com.abdosharaf.composetest2.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home_graph",
        route = "root_graph"
    ) {
        homeNavGraph(navController = navController)
        authNavGraph(navController = navController)
    }
}
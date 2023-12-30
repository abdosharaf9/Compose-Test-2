package com.abdosharaf.composetest2.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.abdosharaf.composetest2.screens.DetailScreen
import com.abdosharaf.composetest2.screens.HomeScreen
import com.abdosharaf.composetest2.navigation.Screen

fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {
    navigation(
        startDestination = Screen.Home.route,
        route = "home_graph"
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.Detail.route) {
            DetailScreen(navController = navController)
        }
    }
}
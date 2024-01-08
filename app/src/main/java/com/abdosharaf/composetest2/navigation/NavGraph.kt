package com.abdosharaf.composetest2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.abdosharaf.composetest2.screens.home.HomeScreen
import com.abdosharaf.composetest2.screens.search.SearchScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(onSearchClicked = {
                navController.navigate(route = Screen.SearchScreen.route)
            })
        }

        composable(route = Screen.SearchScreen.route) {
            SearchScreen(onCloseClicked = {
                navController.popBackStack()
            })
        }
    }
}
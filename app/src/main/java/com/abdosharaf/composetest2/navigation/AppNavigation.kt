package com.abdosharaf.composetest2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.abdosharaf.composetest2.screens.MainScreen
import com.abdosharaf.composetest2.screens.PermissionScreen

@Composable
fun SetupNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Permission.route) {
        composable(route = Screen.Permission.route) {
            PermissionScreen {
                navController.popBackStack()
                navController.navigate(route = Screen.Main.route)
            }
        }

        composable(route = Screen.Main.route) {
            MainScreen()
        }
    }
}
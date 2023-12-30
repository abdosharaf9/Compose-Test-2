package com.abdosharaf.composetest2

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.abdosharaf.composetest2.screens.HomeScreen
import com.abdosharaf.composetest2.screens.ProfileScreen
import com.abdosharaf.composetest2.screens.SettingsScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavigationItem.Home.route) {
        composable(route = BottomNavigationItem.Home.route) {
            HomeScreen()
        }
        composable(route = BottomNavigationItem.Profile.route) {
            ProfileScreen()
        }
        composable(route = BottomNavigationItem.Settings.route) {
            SettingsScreen()
        }
    }
}
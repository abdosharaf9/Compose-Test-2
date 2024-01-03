package com.abdosharaf.composetest2

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.detailsNavigation(navController: NavHostController) {
    navigation(startDestination = Screen.Details.route, route = Graph.Details.route) {
        composable(route = Screen.Details.route) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { navController.navigate(Screen.Information.route) }
            ) {
                Text(text = "Details", fontSize = 26.sp)
            }
        }

        composable(route = Screen.Information.route) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { navController.popBackStack() }
            ) {
                Text(text = "Information", fontSize = 26.sp)
            }
        }
    }
}
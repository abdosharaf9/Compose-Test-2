package com.abdosharaf.composetest2

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument(name = "id") {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(name = "name") {
                    type = NavType.StringType
                    defaultValue = "Abdo Sharaf"
                }
            )
        ) { entry ->
            Log.d("```TAG```", "SetupNavGraph: ${entry.arguments?.getInt("id")}")
//            Log.d("```TAG```", "SetupNavGraph: ${entry.arguments?.getString("name")}")
            DetailScreen(navController = navController)
        }
    }
}
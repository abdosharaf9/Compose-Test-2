package com.abdosharaf.composetest2

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.authNavigation(navController: NavHostController) {
    navigation(startDestination = Screen.Login.route, route = Graph.Auth.route) {
        composable(route = Screen.Login.route) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        navController.popBackStack()
                        navController.navigate(Graph.Home.route)
                    },
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Login", fontSize = 26.sp)
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "SignUp",
                    modifier = Modifier.clickable { navController.navigate(Screen.SignUp.route) })
            }
        }

        composable(route = Screen.SignUp.route) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { navController.popBackStack() },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Sign Up", fontSize = 26.sp)
            }
        }
    }
}
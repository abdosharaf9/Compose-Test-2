package com.abdosharaf.composetest2.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.abdosharaf.composetest2.navigation.Screen

@Composable
@Preview(showBackground = true)
fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}

@Composable
fun LoginScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.SignUp.route)
            },
            text = "Login",
            style = MaterialTheme.typography.displayMedium,
            color = Color.Red
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            modifier = Modifier.clickable {
//                navController.navigate(route = "home_graph") {
//                    popUpTo(route = "home_graph")
//                }

                navController.popBackStack()
                navController.navigate(route = Screen.Detail.route)
            },
            text = "Home/Details",
            style = MaterialTheme.typography.headlineSmall,
            color = Color.Blue
        )
    }
}
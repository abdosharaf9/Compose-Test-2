package com.abdosharaf.composetest2

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavigation(navController: NavHostController) {

    val sharedViewModel: SharedViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController, viewModel = sharedViewModel)
        }

        composable(route = Screen.Details.route) {
//            LaunchedEffect(key1 = it) {
//                val result =
//                    navController.previousBackStackEntry?.savedStateHandle?.get<Person>("person")
//                Log.d("```TAG```", "SetupNavigation: ${result?.firstName}")
//                Log.d("```TAG```", "SetupNavigation: ${result?.secondName}")
//            }
            DetailsScreen(viewModel = sharedViewModel)
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController, viewModel: SharedViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                val person = Person(firstName = "Rosemary", secondName = "Theron")
                viewModel.addPerson(newPerson = person)
//                navController.currentBackStackEntry?.savedStateHandle?.set(
//                    key = "person",
//                    value = person
//                )
                navController.navigate(route = Screen.Details.route)
            },
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Home", fontSize = 24.sp)
    }
}

@Composable
fun DetailsScreen(viewModel: SharedViewModel) {
    val person = viewModel.person
    LaunchedEffect(key1 = person) {
        if(person != null) {
            Log.d("```TAG```", "DetailsScreen: ${person.firstName}")
            Log.d("```TAG```", "DetailsScreen: ${person.secondName}")
        }
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Details", fontSize = 24.sp)
    }
}

sealed class Screen(val route: String) {
    data object Home : Screen(route = "home_screen")
    data object Details : Screen(route = "details_screen")
}
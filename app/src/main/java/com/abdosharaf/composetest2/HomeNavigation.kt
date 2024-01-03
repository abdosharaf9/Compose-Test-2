package com.abdosharaf.composetest2

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = {
            BottomNavigation(navController)
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            HomeNavGraph(navController = navController)
        }
    }
}

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarItem.Home.route,
        route = Graph.Home.route
    ) {
        composable(route = BottomBarItem.Home.route) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { navController.navigate(Graph.Details.route) },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Home", fontSize = 26.sp)
            }
        }

        composable(route = BottomBarItem.Settings.route) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Settings", fontSize = 26.sp)
            }
        }

        composable(route = BottomBarItem.Profile.route) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Profile", fontSize = 26.sp)
            }
        }

        detailsNavigation(navController)
    }
}

@Composable
fun BottomNavigation(navController: NavHostController) {
    val screens = listOf(
        BottomBarItem.Home,
        BottomBarItem.Settings,
        BottomBarItem.Profile
    )
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination
    val bottomBarDestination = screens.any { currentDestination?.route == it.route }

    if (bottomBarDestination) {
        NavigationBar {
            screens.forEach {
                NavigationBarItem(
                    selected = currentDestination?.route == it.route,
                    onClick = {
                        navController.navigate(it.route) {
                            launchSingleTop = true
                            popUpTo(BottomBarItem.Home.route)
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = it.icon,
                            contentDescription = it.title
                        )
                    },
                    label = {
                        Text(text = it.title)
                    }
                )
            }
        }
    }
}
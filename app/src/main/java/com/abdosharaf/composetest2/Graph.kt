package com.abdosharaf.composetest2

sealed class Graph(val route: String) {
    data object Root: Graph(route = "root_graph")
    data object Auth: Graph(route = "auth_graph")
    data object Home: Graph(route = "home_graph")
    data object Details: Graph(route = "details_graph")
}
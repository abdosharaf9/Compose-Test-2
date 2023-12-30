package com.abdosharaf.composetest2

sealed class Screen(val route: String) {
    data object Home : Screen(route = "home_screen")
    data object Detail: Screen(route = "detail_screen?id={id}&name={name}") {
        fun passArguments(id: Int, name: String): String {
            return "detail_screen?id=$id&name=$name"
        }
        fun passId(id: Int): String {
            return "detail_screen?id=$id"
        }
    }

    /*data object Detail : Screen(route = "detail_screen/{id}/{name}") {
        fun passArguments(id: Int, name: String): String {
            return "detail_screen/$id/$name"
        }

        fun passId(id: Int): String {
            return this.route.replace("{id}", id.toString())
        }
    }*/
}
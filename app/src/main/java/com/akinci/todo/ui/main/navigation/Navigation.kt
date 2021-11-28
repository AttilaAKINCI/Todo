package com.akinci.todo.ui.main.navigation

/**
 * For parametered navigation define create route function.
 * **/

sealed class Navigation(val route: String){
    object Splash: Navigation("splash")
    object Login: Navigation("login")
    object Dashboard: Navigation("dashboard")
    object Note: Navigation("note")
}
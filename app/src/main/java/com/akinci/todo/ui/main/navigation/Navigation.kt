package com.akinci.todo.ui.main.navigation

/**
 * For parametered navigation define create route function.
 * **/

/**
 * For a trial Note Screen is marked as "Network Dependent Screen" (NDS)
 * **/
sealed class Navigation(val route: String, val needNetworkConnection: Boolean = false){
    object Splash: Navigation("splash")
    object Login: Navigation("login")
    object Dashboard: Navigation("dashboard")
    object Note: Navigation("note", true)
}
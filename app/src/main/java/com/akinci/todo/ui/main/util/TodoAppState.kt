package com.akinci.todo.ui.main.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.akinci.todo.ui.components.OfflineDialog
import com.akinci.todo.ui.feature.splash.SplashScreenBody
import com.akinci.todo.ui.main.navigation.Navigation
import com.akinci.todo.ui.main.viewmodel.MainViewModel

private fun NavBackStackEntry.lifecycleIsResumed() = this.lifecycle.currentState == Lifecycle.State.RESUMED

@Composable
fun rememberTodoAppState(
    navController: NavHostController = rememberNavController(),
    mainViewModel: MainViewModel = viewModel()
) = remember(navController) {
    TodoAppState(navController, mainViewModel)
}

// TODO in next step network error popup will be moved to each composable screen (base composable).
//  Screens will decide to show content or network error popup or show both. using mainViewModel (will be renamed as networkcheck VM and binded to each comp. screen)
//  TodoAppState.navigate will be moved to extension func. and it will check lifecycle before navigate.
//  In this cond. appstate becomes unnecessary

class TodoAppState(
    val navController: NavHostController,
    val mainViewModel: MainViewModel
) {
    fun navigate(navigationRoute: Navigation, from: NavBackStackEntry) {
        if(!navigationRoute.needNetworkConnection || mainViewModel.checkNetwork()){
            navigate(navigationRoute.route, from)
        }
    }

    fun navigateBack() { navController.popBackStack() }
    private fun navigate(route: String, from: NavBackStackEntry){
        if (from.lifecycleIsResumed()) {
            // In order to discard duplicated navigation events, we check the Lifecycle
            // val encodedUri = Uri.encode(episodeUri)
            // navController.navigate(Screen.Player.createRoute(encodedUri))
            navController.navigate(route)
        }
    }
}
package com.akinci.todo.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.akinci.todo.common.base.BaseActivity
import com.akinci.todo.ui.components.NetworkDependentScreen
import com.akinci.todo.ui.components.OfflineDialog
import com.akinci.todo.ui.feature.dashboard.DashboardScreenBody
import com.akinci.todo.ui.feature.login.LoginScreenBody
import com.akinci.todo.ui.feature.note.NoteScreenBody
import com.akinci.todo.ui.feature.splash.SplashScreenBody
import com.akinci.todo.ui.main.navigation.Navigation
import com.akinci.todo.ui.main.util.TodoAppState
import com.akinci.todo.ui.main.util.rememberTodoAppState
import com.akinci.todo.ui.theme.TodoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoApp()
        }
    }
}

@Composable
fun TodoApp(
    appState: TodoAppState = rememberTodoAppState()
){
    TodoTheme {
        //  val navController = rememberNavController()
        //  val backstackEntry = navController.currentBackStackEntryAsState()
        //  val currentScreen = MainNavigation.fromRoute(backstackEntry.value?.destination?.route)

        Scaffold(
            // TODO fill later
        ) { innerPadding ->
            MainNavHost(appState, modifier = Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun MainNavHost(
    appState: TodoAppState,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = appState.navController,
        startDestination = Navigation.Splash.route,
        modifier = modifier
    ){

        composable(route = Navigation.Splash.route){
            SplashScreenBody(onClick = { appState.navigate(Navigation.Login, it) })
        }
        composable(route = Navigation.Login.route){
            LoginScreenBody(onClick = { appState.navigate(Navigation.Dashboard, it) })
        }
        composable(route = Navigation.Dashboard.route){
            /** For a trial Dashboard Screen is marked as "Network Dependent Screen" (NDS) **/
            NetworkDependentScreen(retryAction = { appState.navigateBack() }) {
                DashboardScreenBody(onClick = { appState.navigate(Navigation.Note, it) })
            }
        }
        composable(route = Navigation.Note.route){
            NoteScreenBody(onClick = { appState.navigateBack() })
        }
    }
}
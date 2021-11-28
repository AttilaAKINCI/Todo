package com.akinci.todo.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.akinci.todo.ui.feature.dashboard.DashboardScreenBody
import com.akinci.todo.ui.feature.login.LoginScreenBody
import com.akinci.todo.ui.feature.note.NoteScreenBody
import com.akinci.todo.ui.feature.splash.SplashScreenBody
import com.akinci.todo.ui.main.navigation.Navigation
import com.akinci.todo.ui.theme.TodoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoApp()
        }
    }
}

@Composable
fun TodoApp(){
    TodoTheme {
        val navController = rememberNavController()
      //  val backstackEntry = navController.currentBackStackEntryAsState()
      //  val currentScreen = MainNavigation.fromRoute(backstackEntry.value?.destination?.route)

        Scaffold(
            // TODO fill later
        ) { innerPadding ->
            MainNavHost(navController, modifier = Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = Navigation.Splash.route,
        modifier = modifier
    ){

        /**
         * TODO navigation between screen should be provided with lambda function actions.
         *  do not pass navController inside. and entire navController logic
         *  should stay in the same file.
         * **/

        composable(route = Navigation.Splash.route){
            SplashScreenBody(onClick = { navController.navigate(Navigation.Login.route) })
        }
        composable(route = Navigation.Login.route){
            LoginScreenBody(onClick = { navController.navigate(Navigation.Dashboard.route) })
        }
        composable(route = Navigation.Dashboard.route){
            DashboardScreenBody(onClick = { navController.navigate(Navigation.Note.route) })
        }
        composable(route = Navigation.Note.route){
            NoteScreenBody(onClick = { navController.popBackStack() })
        }
    }
}
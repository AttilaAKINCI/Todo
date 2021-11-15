package com.akinci.todo.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.akinci.todo.ui.feature.dashboard.DashboardScreenBody
import com.akinci.todo.ui.feature.login.LoginScreenBody
import com.akinci.todo.ui.feature.note.NoteScreenBody
import com.akinci.todo.ui.feature.splash.SplashScreenBody
import com.akinci.todo.ui.main.navigation.MainNavigation
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
        val backstackEntry = navController.currentBackStackEntryAsState()
        val currentScreen = MainNavigation.fromRoute(backstackEntry.value?.destination?.route)

        Scaffold(
            // TODO fill later
        ) { innerPadding ->
            MainNavHost(navController, modifier = Modifier.padding(innerPadding))
        }

        // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.background) {
//                    Greeting("Android")
//                }
    }
}

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = MainNavigation.SplashPage.name,
        modifier = modifier
    ){
        composable(MainNavigation.SplashPage.name){
            SplashScreenBody(name = "!!")
        }
        composable(MainNavigation.LoginPage.name){
            LoginScreenBody(name = "!!")
        }
        composable(MainNavigation.DashboardPage.name){
            DashboardScreenBody(name = "!!")
        }
        composable(MainNavigation.NotePage.name){
            NoteScreenBody(name = "!!")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodoTheme {
        Greeting("Android")
    }
}
package com.akinci.todo.ui.feature.splash

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.akinci.todo.ui.theme.TodoTheme

@Composable
fun SplashScreenBody(name: String) {
    Text(text = "Splash Screen $name")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodoTheme {
        SplashScreenBody("Android")
    }
}
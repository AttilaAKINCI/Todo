package com.akinci.todo.ui.feature.login

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.akinci.todo.ui.theme.TodoTheme

@Composable
fun LoginScreenBody(name: String) {
    Text(text = "Login Screen $name")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodoTheme {
        LoginScreenBody("Android")
    }
}
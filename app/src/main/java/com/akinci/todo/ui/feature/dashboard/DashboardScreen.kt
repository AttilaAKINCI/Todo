package com.akinci.todo.ui.feature.dashboard

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.akinci.todo.ui.theme.TodoTheme

@Composable
fun DashboardScreenBody(name: String) {
    Text(text = "Dashboard Screen $name")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodoTheme {
        DashboardScreenBody("Android")
    }
}
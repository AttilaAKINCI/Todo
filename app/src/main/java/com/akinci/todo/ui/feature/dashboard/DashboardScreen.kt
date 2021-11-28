package com.akinci.todo.ui.feature.dashboard

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.akinci.todo.R
import com.akinci.todo.ui.components.PageNavigator
import com.akinci.todo.ui.theme.TodoTheme

@Composable
fun DashboardScreenBody(
    onClick : ()->Unit
) {
    PageNavigator(
        R.string.dashboard_page,
        onClick = onClick
    )
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    TodoTheme {
        DashboardScreenBody(onClick = { })
    }
}
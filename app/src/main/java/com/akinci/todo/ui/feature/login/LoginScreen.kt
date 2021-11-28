package com.akinci.todo.ui.feature.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.akinci.todo.R
import com.akinci.todo.ui.components.PageNavigator
import com.akinci.todo.ui.theme.TodoTheme

@Composable
fun LoginScreenBody(
    onClick : ()->Unit
) {
    PageNavigator(
        R.string.login_page,
        onClick = onClick
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodoTheme {
        LoginScreenBody(onClick = { })
    }
}
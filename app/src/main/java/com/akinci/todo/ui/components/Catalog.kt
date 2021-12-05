package com.akinci.todo.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.akinci.todo.ui.theme.TodoTheme

/**
 *
 *  This file contains components which are used app wide.
 *  Can be considered as component catalog of this app.
 *
 * **/

@Preview(showBackground = true)
@Composable
fun Catalog_PageNavigator() {
    TodoTheme {
        PageNavigator(onClick = { })
    }
}

@Preview(showBackground = true)
@Composable
fun Catalog_OfflineDialog() {
    TodoTheme {
        OfflineDialog(onRetry = { })
    }
}
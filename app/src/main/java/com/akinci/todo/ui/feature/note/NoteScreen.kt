package com.akinci.todo.ui.feature.note

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.akinci.todo.R
import com.akinci.todo.ui.components.PageNavigator
import com.akinci.todo.ui.theme.TodoTheme

@Composable
fun NoteScreenBody(
    onClick : ()->Unit
) {
    PageNavigator(
        navigatorMessageId = R.string.note_page,
        navigateButtonMessageId = R.string.button_prev_page,
        onClick = onClick
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodoTheme {
        NoteScreenBody(onClick = { })
    }
}
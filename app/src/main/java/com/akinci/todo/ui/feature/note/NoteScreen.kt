package com.akinci.todo.ui.feature.note

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.akinci.todo.ui.theme.TodoTheme

@Composable
fun NoteScreenBody(name: String) {
    Text(text = "Note Screen $name")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodoTheme {
        NoteScreenBody("Android")
    }
}
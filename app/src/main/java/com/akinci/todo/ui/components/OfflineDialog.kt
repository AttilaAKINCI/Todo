package com.akinci.todo.ui.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.akinci.todo.R
import com.akinci.todo.common.network.NetworkState
import com.akinci.todo.ui.theme.TodoTheme

@Composable
fun OfflineDialog(
    networkState: NetworkState = NetworkState.None,
    onRetry: () -> Unit
) {
    if(networkState is NetworkState.NotConnected){
        AlertDialog(
            onDismissRequest = {},
            title = { Text(text = stringResource(R.string.connection_error_title)) },
            text = { Text(text = stringResource(R.string.connection_error_message)) },
            confirmButton = {
                TextButton(onClick = onRetry) {
                    Text(stringResource(R.string.retry_label))
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOfflineDialog() {
    TodoTheme {
        OfflineDialog(
            networkState = NetworkState.None,
            onRetry = { }
        )
    }
}
package com.akinci.todo.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.akinci.todo.common.network.NetworkState
import com.akinci.todo.common.network.NetworkStateViewModel
import com.akinci.todo.ui.main.navigation.Navigation
import com.akinci.todo.ui.main.util.TodoAppState

@Composable
fun NetworkDependentScreen(
    modifier: Modifier = Modifier,
    appState: TodoAppState,
    networkStateViewModel: NetworkStateViewModel = hiltViewModel(),
    content: @Composable () -> Unit
) {
    val networkState by networkStateViewModel.networkState.collectAsState(initial = NetworkState.None)

    Box(modifier = modifier){
        OfflineDialog(networkState = networkState) { appState.navigateBack() }
        content()
    }
}
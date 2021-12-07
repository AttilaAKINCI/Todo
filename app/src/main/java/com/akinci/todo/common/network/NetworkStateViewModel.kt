package com.akinci.todo.common.network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.akinci.todo.common.coroutine.CoroutineContextProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NetworkStateViewModel @Inject constructor(
    coroutineContext: CoroutineContextProvider,
    networkChecker: NetworkChecker
): ViewModel() {

    /** I set replay parameter as 1 so last value of networkState will be always collected **/
    private val _networkState = MutableSharedFlow<NetworkState>(replay = 1)
    val networkState: SharedFlow<NetworkState> = _networkState

    /**
     *  This VM is created for distribution of network state properly.
     *  We need to bind singleton networkChecker objects network events to composable.
     *  VMs can be directly bind to composable according to depended scope.
     *  If scope is not changed, same VM will be bind on each time.
     * **/

    init {
        viewModelScope.launch(coroutineContext.IO) {
            networkChecker.networkState.collect {
                /** Emit state changes **/
                _networkState.emit(it)
            }
        }
    }
}
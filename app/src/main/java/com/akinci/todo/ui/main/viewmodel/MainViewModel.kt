package com.akinci.todo.ui.main.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.akinci.todo.common.network.NetworkChecker
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val networkChecker: NetworkChecker
): ViewModel() {

    var isNetworkAvailable by mutableStateOf(networkChecker.isNetworkConnected())
    private set

    init { }

    fun checkNetwork() = networkChecker.isNetworkConnected().apply {
        isNetworkAvailable = this
    }
}
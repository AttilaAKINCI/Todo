package com.akinci.todo.common.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NetworkChecker constructor(
    private val context: Context
) {

    private val _networkState = MutableStateFlow<NetworkState>(NetworkState.None)
    val networkState: StateFlow<NetworkState> = _networkState

    private val validTransportTypes = listOf(
        NetworkCapabilities.TRANSPORT_WIFI,
        NetworkCapabilities.TRANSPORT_CELLULAR
    )

    private val networkCallback by lazy {
        object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                _networkState.value = NetworkState.Connected
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                _networkState.value = NetworkState.NotConnected
            }
        }
    }

    private val connectivityManager: ConnectivityManager by lazy {
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    init {
        /** initial value of stateflow is set **/
        connectivityManager.activeNetwork?.let { network ->
            connectivityManager.getNetworkCapabilities(network)?.let {  networkCapabilities ->
                if(validTransportTypes.any { networkCapabilities.hasTransport(it) }){
                    _networkState.value = NetworkState.Connected
                }else{
                    _networkState.value = NetworkState.NotConnected
                }
            } ?: run {
                _networkState.value = NetworkState.NotConnected
            }
        } ?: run {
            _networkState.value = NetworkState.NotConnected
        }

        /** update stateflow when status changed. **/
        connectivityManager.registerNetworkCallback(
            NetworkRequest.Builder()
                .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
                .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                .build(),
            networkCallback
        )
    }
}
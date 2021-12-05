package com.akinci.todo.common.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

class NetworkChecker constructor(
    private val context: Context
) {
    fun isNetworkConnected(): Boolean {
        val connectivityManager = context.getSystemService(
                Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager

        val networkCapabilities = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false

        val validTransportTypes =
                listOf(
                        NetworkCapabilities.TRANSPORT_WIFI,
                        NetworkCapabilities.TRANSPORT_CELLULAR,
                        NetworkCapabilities.TRANSPORT_ETHERNET
                )

        return validTransportTypes.any {
            activeNetwork.hasTransport(it)
        }
    }
}
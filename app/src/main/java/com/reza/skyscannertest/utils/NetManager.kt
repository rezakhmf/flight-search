package com.reza.skyscannertest.utils

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject

class NetManager  @Inject constructor(var appContext: Context) {

    val isConnectedToInternet: Boolean
    get() {

        val conManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager

        val networkInfo = conManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}
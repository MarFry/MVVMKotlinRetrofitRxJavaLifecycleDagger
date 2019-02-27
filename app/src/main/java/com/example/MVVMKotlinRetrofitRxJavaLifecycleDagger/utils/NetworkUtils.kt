package com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.utils

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject


class NetworkUtils @Inject constructor(private val context: Context) {

    fun isNetworkAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        val activeNetworkInfo = connectivityManager!!.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}
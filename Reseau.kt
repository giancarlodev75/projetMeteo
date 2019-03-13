package com.example.a01helloworld2

import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity

class Reseau {

    companion object {
        fun reseauok(activity: AppCompatActivity):Boolean{
            val connectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }
    }
}
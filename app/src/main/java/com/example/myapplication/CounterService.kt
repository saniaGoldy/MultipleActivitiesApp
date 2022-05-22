package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class CounterService : Service() {

    private val binder = ServiceBinder()
    private var counter = 0

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    fun getHowManyTimesWasAccessed(): Int{
        Log.d("MyApp", "getHowManyTimesWasAccessed: $counter")
        return counter++
    }

    inner class ServiceBinder: Binder(){
        fun getService() = this@CounterService
    }
}
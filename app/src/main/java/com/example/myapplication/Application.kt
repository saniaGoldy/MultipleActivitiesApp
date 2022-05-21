package com.example.myapplication

import android.app.Application

class ApplicationEx : Application() {
    override fun onCreate() {
        super.onCreate()
        // This is for registering the listener class
        registerActivityLifecycleCallbacks(ActivityLifecycleListener(this))

    }
}

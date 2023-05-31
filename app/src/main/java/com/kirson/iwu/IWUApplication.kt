package com.kirson.iwu

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class IWUApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }

}
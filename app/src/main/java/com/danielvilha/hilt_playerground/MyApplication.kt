package com.danielvilha.hilt_playerground

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
@HiltAndroidApp
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}
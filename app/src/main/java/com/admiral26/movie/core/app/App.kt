package com.admiral26.movie.core.app

import android.app.Application
import com.admiral26.movie.BuildConfig
import timber.log.Timber

class App : Application() {

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }


    }

}
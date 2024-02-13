package com.admiral26.movie.core.app

import android.app.Application
import com.admiral26.movie.BuildConfig
import com.admiral26.movie.core.di.networkModule
import com.admiral26.movie.core.di.repoModule
import com.admiral26.movie.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
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

        startKoin {
            androidContext(this@App)
            modules(arrayListOf(networkModule, repoModule, viewModelModule))
        }


    }

}
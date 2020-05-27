package com.example.di

import android.app.Application
import com.example.di.di.apiModule
import com.example.di.di.netModule
import com.example.di.di.repositoryModule
import com.example.di.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MyApplication)
            modules(listOf(viewModelModule, apiModule, netModule, repositoryModule))
        }
    }
}
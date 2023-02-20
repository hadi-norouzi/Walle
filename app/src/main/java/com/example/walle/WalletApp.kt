package com.example.walle

import android.app.Application
import com.example.walle.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WalletApp: Application() {


    override fun onCreate() {
        startKoin {
            androidLogger()
            androidContext(this@WalletApp)
            modules(appModule)
        }
        super.onCreate()
    }
}


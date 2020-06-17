package com.leandroid.formula1

import android.app.Application
import com.leandroid.data.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CommomApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@CommomApplication)
            modules(listOf(
                dataModule, presentationModule
            ))
        }
    }
}


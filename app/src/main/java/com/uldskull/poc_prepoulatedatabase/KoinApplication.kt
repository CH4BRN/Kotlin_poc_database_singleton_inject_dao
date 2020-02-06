// File KoinApplication.kt
// @Author pierre.antoine - 05/02/2020 - No copyright.

package com.uldskull.poc_prepoulatedatabase

import android.app.Application
import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 *   Class "KoinApplication" :
 *   TODO: Fill class use.
 **/
class KoinApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(appModule)
        }
    }
}
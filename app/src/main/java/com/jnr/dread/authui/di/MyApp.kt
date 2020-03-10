package com.jnr.dread.authui.di

import android.app.Application

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initializeKoin()
    }
    private fun initializeKoin() {
        AppInjector.initialise(this@MyApp)
    }
}
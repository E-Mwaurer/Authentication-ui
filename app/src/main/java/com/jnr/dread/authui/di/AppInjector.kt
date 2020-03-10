package com.jnr.dread.authui.di

import android.content.Context
import com.jnr.dread.auth_ui.LoginPayload
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

object AppInjector {
    fun initialise(androidContext: Context) {
        startKoin {
            androidContext(androidContext)
            androidLogger()
            modules(listOf(koinAuthModule))
        }
    }

    private val koinAuthModule = module {
        factory { (user: String, secret: String) -> LoginPayload(user, secret) }
    }
}
package com.example.ominext.cleanarch.common.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class CommonModule(private val application: Application) {
    @Provides
    fun providesApplicationContext(): Context {
        return application.applicationContext
    }
}
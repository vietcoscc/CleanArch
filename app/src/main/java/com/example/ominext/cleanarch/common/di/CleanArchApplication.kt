package com.example.ominext.cleanarch.common.di

import android.annotation.SuppressLint
import android.app.Application
import com.example.ominext.cleanarch.common.di.component.AppComponent
import com.example.ominext.cleanarch.common.di.component.DaggerAppComponent
import com.example.ominext.cleanarch.common.di.module.CommonModule
import com.example.ominext.cleanarch.common.di.module.RepositoryModule

@SuppressLint("Registered")
class CleanArchApplication : Application() {
    lateinit var appComponent: AppComponent

    open fun appComponent(): AppComponent {
        return appComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    protected open fun initDagger() {
        this.appComponent = DaggerAppComponent.builder()
                .commonModule(CommonModule(this))
                .repositoryModule(RepositoryModule())
                .build()
    }
}
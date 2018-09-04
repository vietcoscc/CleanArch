package com.example.ominext.cleanarch.common.di.component

import com.example.ominext.cleanarch.common.di.module.ApiModule
import com.example.ominext.cleanarch.common.di.module.CommonModule
import com.example.ominext.cleanarch.common.di.module.RepositoryModule
import com.example.ominext.cleanarch.presentasion.fragment.MainFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CommonModule::class, RepositoryModule::class, ApiModule::class])
interface AppComponent {
    fun inject(fragment: MainFragment)
}
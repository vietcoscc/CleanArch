package com.example.ominext.cleanarch.common.di.module

import com.example.ominext.cleanarch.data.repository.MainReposImp
import com.example.ominext.cleanarch.domain.repository.MainRepos
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun providesMainRepository(repository: MainReposImp): MainRepos {
        return repository
    }
}
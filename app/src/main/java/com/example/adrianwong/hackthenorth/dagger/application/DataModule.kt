package com.example.adrianwong.hackthenorth.dagger.application

import com.example.adrianwong.hackthenorth.api.ApiService
import com.example.adrianwong.hackthenorth.repository.PoolRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    @ApplicationScope
    fun providePoolRepositoryImpl(apiService: ApiService) = PoolRepositoryImpl(apiService)
}
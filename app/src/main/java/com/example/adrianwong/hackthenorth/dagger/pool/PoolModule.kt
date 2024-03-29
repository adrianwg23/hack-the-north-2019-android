package com.example.adrianwong.hackthenorth.dagger.pool

import com.example.adrianwong.hackthenorth.pool.PoolPresenter
import com.example.adrianwong.hackthenorth.repository.RepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class PoolModule {

    @Provides
    @DashboardScope
    fun providesPoolPresenter(repositoryImpl: RepositoryImpl) = PoolPresenter(repositoryImpl)
}
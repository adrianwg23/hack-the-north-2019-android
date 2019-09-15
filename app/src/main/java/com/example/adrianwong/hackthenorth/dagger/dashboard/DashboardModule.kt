package com.example.adrianwong.hackthenorth.dagger.pool

import com.example.adrianwong.hackthenorth.dashboard.DashboardPresenter
import com.example.adrianwong.hackthenorth.repository.RepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class DashboardModule {

    @Provides
    @DashboardScope
    fun providesDashboardPresenter(repositoryImpl: RepositoryImpl) = DashboardPresenter(repositoryImpl)
}
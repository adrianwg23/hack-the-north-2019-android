package com.example.adrianwong.hackthenorth.dagger.pool

import com.example.adrianwong.hackthenorth.dashboard.DashboardPresenter
import com.example.adrianwong.hackthenorth.individual.IndividualPresenter
import com.example.adrianwong.hackthenorth.repository.RepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class IndividualModule {

    @Provides
    @DashboardScope
    fun providesIndividualPresenter(repositoryImpl: RepositoryImpl) = IndividualPresenter(repositoryImpl)
}
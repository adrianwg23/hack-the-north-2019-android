package com.example.adrianwong.hackthenorth.dagger

import com.example.adrianwong.hackthenorth.dagger.application.ApplicationModule
import com.example.adrianwong.hackthenorth.dagger.application.ApplicationScope
import com.example.adrianwong.hackthenorth.dagger.application.DataModule
import com.example.adrianwong.hackthenorth.dagger.application.NetworkModule
import com.example.adrianwong.hackthenorth.dagger.pool.*
import dagger.Component
import dagger.Subcomponent

@ApplicationScope
@Component(modules = [ApplicationModule::class, DataModule::class, NetworkModule::class])
interface MainComponent {

    fun plusPoolSubcomponent(poolModule: PoolModule): PoolSubcomponent

    fun plusIndividualSubcomponent(individualModule: IndividualModule): IndividualSubcomponent

    fun plusDashboardSubcomponent(dashboardModule: DashboardModule): DashboardSubcomponent

}
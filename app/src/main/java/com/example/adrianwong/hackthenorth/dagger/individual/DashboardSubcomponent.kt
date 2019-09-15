package com.example.adrianwong.hackthenorth.dagger.pool

import com.example.adrianwong.hackthenorth.dashboard.DashboardFragment
import com.example.adrianwong.hackthenorth.individual.IndividualFragment
import com.example.adrianwong.hackthenorth.pool.PoolFragment
import dagger.Subcomponent

@DashboardScope
@Subcomponent(modules = [IndividualModule::class])
interface IndividualSubcomponent {
    fun inject(individualFragment: IndividualFragment)
}
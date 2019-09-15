package com.example.adrianwong.hackthenorth.dagger.pool

import com.example.adrianwong.hackthenorth.dashboard.DashboardFragment
import com.example.adrianwong.hackthenorth.pool.PoolFragment
import dagger.Subcomponent

@DashboardScope
@Subcomponent(modules = [DashboardModule::class])
interface DashboardSubcomponent {
    fun inject(dashboardFragment: DashboardFragment)
}
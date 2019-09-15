package com.example.adrianwong.hackthenorth

import android.app.Application
import com.example.adrianwong.hackthenorth.dagger.DaggerMainComponent
import com.example.adrianwong.hackthenorth.dagger.MainComponent
import com.example.adrianwong.hackthenorth.dagger.pool.*

class MainApplication : Application() {

    private lateinit var mainComponent: MainComponent
    private var poolSubcomponent: PoolSubcomponent? = null
    private var dashboardSubcomponent: DashboardSubcomponent? = null
    private var individualSubcomponent: IndividualSubcomponent? = null

    override fun onCreate() {
        super.onCreate()

        mainComponent = DaggerMainComponent.builder()
            .build()
    }

    fun createPoolSubcomponent(): PoolSubcomponent {
        poolSubcomponent = mainComponent.plusPoolSubcomponent(PoolModule())
        return poolSubcomponent!!
    }

    fun createIndividualSubcomponent(): IndividualSubcomponent {
        individualSubcomponent = mainComponent.plusIndividualSubcomponent(IndividualModule())
        return individualSubcomponent!!
    }

    fun createDashboardSubcomponent(): DashboardSubcomponent {
        dashboardSubcomponent = mainComponent.plusDashboardSubcomponent(DashboardModule())
        return dashboardSubcomponent!!
    }

    fun releasePoolSubcomponent() {
        poolSubcomponent = null
    }

    fun releaseIndividualSubcomponent() {
        individualSubcomponent = null
    }

    fun releaseDashboardSubcomponent() {
        dashboardSubcomponent = null
    }
}
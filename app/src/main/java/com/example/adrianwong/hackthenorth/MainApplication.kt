package com.example.adrianwong.hackthenorth

import android.app.Application
import com.example.adrianwong.hackthenorth.dagger.DaggerMainComponent
import com.example.adrianwong.hackthenorth.dagger.MainComponent
import com.example.adrianwong.hackthenorth.dagger.pool.DashboardModule
import com.example.adrianwong.hackthenorth.dagger.pool.DashboardSubcomponent
import com.example.adrianwong.hackthenorth.dagger.pool.PoolModule
import com.example.adrianwong.hackthenorth.dagger.pool.PoolSubcomponent

class MainApplication : Application() {

    private lateinit var mainComponent: MainComponent
    private var poolSubcomponent: PoolSubcomponent? = null
    private var dashboardSubcomponent: DashboardSubcomponent? = null


    override fun onCreate() {
        super.onCreate()

        mainComponent = DaggerMainComponent.builder()
            .build()
    }

    fun createPoolSubcomponent(): PoolSubcomponent {
        poolSubcomponent = mainComponent.plusPoolSubcomponent(PoolModule())
        return poolSubcomponent!!
    }

    fun createDashboardSubcomponent(): DashboardSubcomponent {
        dashboardSubcomponent = mainComponent.plusDashboardSubcomponent(DashboardModule())
        return dashboardSubcomponent!!
    }

    fun releasePoolSubcomponent() {
        poolSubcomponent = null
    }

    fun releaseDashboardSubcomponent() {
        dashboardSubcomponent = null
    }
}
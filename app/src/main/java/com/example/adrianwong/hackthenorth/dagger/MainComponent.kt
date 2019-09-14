package com.example.adrianwong.hackthenorth.dagger

import com.example.adrianwong.hackthenorth.dagger.application.ApplicationModule
import com.example.adrianwong.hackthenorth.dagger.application.ApplicationScope
import com.example.adrianwong.hackthenorth.dagger.application.DataModule
import com.example.adrianwong.hackthenorth.dagger.application.NetworkModule
import com.example.adrianwong.hackthenorth.dagger.pool.PoolModule
import com.example.adrianwong.hackthenorth.dagger.pool.PoolSubcomponent
import dagger.Component

@ApplicationScope
@Component(modules = [ApplicationModule::class, DataModule::class, NetworkModule::class])
interface MainComponent {

    fun plusPoolSubcomponent(poolModule: PoolModule): PoolSubcomponent

}
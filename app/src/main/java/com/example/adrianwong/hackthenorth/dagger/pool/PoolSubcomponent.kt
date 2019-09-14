package com.example.adrianwong.hackthenorth.dagger.pool

import com.example.adrianwong.hackthenorth.pool.PoolFragment
import dagger.Subcomponent

@PoolScope
@Subcomponent(modules = [PoolModule::class])
interface PoolSubcomponent {
    fun inject(poolFragment: PoolFragment)
}
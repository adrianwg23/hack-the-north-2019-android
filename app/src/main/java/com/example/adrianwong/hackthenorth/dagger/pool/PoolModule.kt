package com.example.adrianwong.hackthenorth.dagger.pool

import com.example.adrianwong.hackthenorth.pool.PoolPresenter
import com.example.adrianwong.hackthenorth.repository.PoolRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class PoolModule {

    @Provides
    @PoolScope
    fun providesPoolPresenter(poolRepositoryImpl: PoolRepositoryImpl) = PoolPresenter(poolRepositoryImpl)
}
package com.example.adrianwong.hackthenorth.pool

import com.example.adrianwong.hackthenorth.repository.PoolRepositoryImpl

class PoolPresenter(private val poolRepository: PoolRepositoryImpl) : PoolContract.Presenter {

    private lateinit var poolView: PoolContract.View

    override fun attachView(view: PoolContract.View) {
        poolView = view
    }

    override fun submitDonation() {

    }
}
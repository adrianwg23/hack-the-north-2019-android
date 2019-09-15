package com.example.adrianwong.hackthenorth.repository

import com.example.adrianwong.hackthenorth.api.ApiService
import com.example.adrianwong.hackthenorth.datamodels.AllPoolWrapper
import com.example.adrianwong.hackthenorth.datamodels.CurrentPool
import com.example.adrianwong.hackthenorth.datamodels.ResultWrapper
import io.reactivex.Observable
import io.reactivex.Single

class RepositoryImpl(private val apiService: ApiService) {

    fun getCurrentPoolFunction(): Observable<CurrentPool> {
        return apiService.getCurrentPoolFunction().toObservable()
    }

    fun getAllPoolFunction(): Observable<AllPoolWrapper> {
        return apiService.getAllPoolFunction().toObservable()
    }

    fun donateToPool(donorId: String, amount: Int): Single<ResultWrapper> {
        return apiService.donateToPool(donorId, amount)
    }
    
    fun donateToIndividual(donorId: String, recieverId: String, amount: Int): Single<ResultWrapper> {
        return apiService.donateToIndividual(donorId, recieverId, amount)
    }
}
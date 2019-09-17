package com.example.adrianwong.hackthenorth.repository

import com.example.adrianwong.hackthenorth.api.ApiService
import com.example.adrianwong.hackthenorth.datamodels.*
import io.reactivex.Observable
import io.reactivex.Single

class RepositoryImpl(private val apiService: ApiService) {

    fun getCurrentPoolFunction(): Observable<CurrentPool> {
        return apiService.getCurrentPoolFunction().toObservable()
    }

    fun getAllPoolFunction(): Observable<List<CurrentPool>> {
        return apiService.getAllPoolFunction().toObservable()
    }

    fun donateToPool(donorId: String, amount: Int): Single<ResultWrapper> {
        return apiService.donateToPool(donorId, amount)
    }

    fun donateToIndividual(
        donorId: String,
        recieverId: String,
        amount: Int
    ): Single<ResultWrapper> {
        return apiService.donateToIndividual(donorId, recieverId, amount)
    }

    fun getReceiverInfo(receiverId: String): Single<ReceiverWrapper> {
        return apiService.getReceiverInfo(receiverId)
    }

    fun merchantMinus(recieverId: String, amount: Int): Single<ResultWrapper> {
        return apiService.merchantMinus(recieverId, amount.toString())
    }

    fun getDonorInfo(donorId: String): Single<DonorInfo> {
        return apiService.getDonorInfo(donorId)
    }
}
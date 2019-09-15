package com.example.adrianwong.hackthenorth.repository

import com.example.adrianwong.hackthenorth.api.ApiService
import com.example.adrianwong.hackthenorth.datamodels.Result
import io.reactivex.Observable

class PoolRepositoryImpl(private val apiService: ApiService) {

    fun pingFunction(): Observable<Result> {
        return apiService.pingFunction().toObservable()
    }

}
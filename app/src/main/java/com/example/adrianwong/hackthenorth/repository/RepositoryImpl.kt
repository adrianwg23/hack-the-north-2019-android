package com.example.adrianwong.hackthenorth.repository

import com.example.adrianwong.hackthenorth.api.ApiService
import com.example.adrianwong.hackthenorth.datamodels.AllPoolWrapper
import com.example.adrianwong.hackthenorth.datamodels.CurrentPool
import io.reactivex.Observable

class RepositoryImpl(private val apiService: ApiService) {

    fun getCurrentPoolFunction(): Observable<CurrentPool> {
        return apiService.getCurrentPoolFunction().toObservable()
    }

    fun getAllPoolFunction(): Observable<AllPoolWrapper> {
        return apiService.getAllPoolFunction().toObservable()
    }

}
package com.example.adrianwong.hackthenorth.api

import com.example.adrianwong.hackthenorth.datamodels.AllPoolWrapper
import com.example.adrianwong.hackthenorth.datamodels.CurrentPool
import com.example.adrianwong.hackthenorth.datamodels.ResultWrapper
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("getCurrentPool") //current pool of today total val
    fun getCurrentPoolFunction(): Single<CurrentPool>

    @GET("getAllPool") //history of above
    fun getAllPoolFunction(): Single<AllPoolWrapper>

    @GET("donateToPool")
    fun donateToPool(@Query("donorId") donorId: String, @Query("amount") amount: Int): Single<ResultWrapper>
}
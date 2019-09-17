package com.example.adrianwong.hackthenorth.api

import com.example.adrianwong.hackthenorth.datamodels.*
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("getCurrentPool") //current pool of today total val
    fun getCurrentPoolFunction(): Single<CurrentPool>

    @GET("getDonorInfo") //current pool of today total val
    fun getDonorInfo(@Query("donorId") donorId: String): Single<DonorInfo>

    @GET("getAllPool") //history of above
    fun getAllPoolFunction(): Single<List<CurrentPool>>

    @GET("donateToPool")
    fun donateToPool(@Query("donorId") donorId: String, @Query("amount") amount: Int): Single<ResultWrapper>

    @GET("donateToIndividual")
    fun donateToIndividual(@Query("donorId") donorId: String,
                           @Query("receiverId") receiverId : String,
                           @Query("amount") amount: Int): Single<ResultWrapper>

    @GET("getReceiverInfo")
    fun getReceiverInfo(@Query("receiverId") receiverId: String): Single<ReceiverWrapper>

    @GET("merchantMinus")
    fun merchantMinus(@Query("receiverId") receiverId: String,
                             @Query("amount") amount: String): Single<ResultWrapper>
}
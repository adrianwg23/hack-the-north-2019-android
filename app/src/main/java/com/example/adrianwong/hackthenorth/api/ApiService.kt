package com.example.adrianwong.hackthenorth.api

import com.example.adrianwong.hackthenorth.datamodels.AllPoolWrapper
import com.example.adrianwong.hackthenorth.datamodels.CurrentPool
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("getCurrentPool") //current pool of today total val
    fun getCurrentPoolFunction(): Single<CurrentPool>

    @GET("getAllPool") //history of above
    fun getAllPoolFunction(): Single<AllPoolWrapper>
}
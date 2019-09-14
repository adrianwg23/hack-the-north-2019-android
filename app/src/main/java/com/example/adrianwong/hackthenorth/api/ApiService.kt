package com.example.adrianwong.hackthenorth.api

import com.example.adrianwong.hackthenorth.datamodels.Result
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("pingFunction")
    fun pingFunction(): Single<Result>

}
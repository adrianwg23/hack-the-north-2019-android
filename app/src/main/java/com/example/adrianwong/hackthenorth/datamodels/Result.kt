package com.example.adrianwong.hackthenorth.datamodels

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("result")
    var result: String
)
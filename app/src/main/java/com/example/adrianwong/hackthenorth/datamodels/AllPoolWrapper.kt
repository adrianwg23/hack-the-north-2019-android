package com.example.adrianwong.hackthenorth.datamodels

import com.google.gson.annotations.SerializedName

data class AllPoolWrapper(
    var arrayList: ArrayList<CurrentPool>
)

data class ResultWrapper(
    @SerializedName("result")
    var result: String
)
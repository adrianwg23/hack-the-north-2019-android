package com.example.adrianwong.hackthenorth.datamodels

import com.google.gson.annotations.SerializedName

data class AllPoolWrapper(
    var arrayList: ArrayList<CurrentPool>
)

data class ResultWrapper(
    @SerializedName("result")
    var result: String
)

data class ReceiverWrapper(
    @SerializedName("name")
    var name: String,

    @SerializedName("balance")
    var balance: String
)
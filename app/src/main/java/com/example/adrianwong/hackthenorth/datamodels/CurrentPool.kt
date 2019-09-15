package com.example.adrianwong.hackthenorth.datamodels

import com.google.gson.annotations.SerializedName

data class CurrentPool(
    @SerializedName("totalAmount")
    var totalAmount: Int,
    
    @SerializedName("date")
    var date : String
)
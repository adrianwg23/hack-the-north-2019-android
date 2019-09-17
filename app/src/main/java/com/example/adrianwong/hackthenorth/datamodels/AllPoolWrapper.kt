package com.example.adrianwong.hackthenorth.datamodels

import com.google.gson.annotations.SerializedName

data class AllPoolWrapper(
    var allPoolArrayList: List<CurrentPool>
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

data class DonorInfo(
    @SerializedName("name")
    var name: String,

    @SerializedName("currentDayDonation")
    var currentDayDonation: Double,

    @SerializedName("pastDonations")
    var pastDonations: List<DonationsInfo>
)

data class DonationsInfo(
    @SerializedName("amount")
    var amount: Double,

    @SerializedName("date")
    var date: String
)
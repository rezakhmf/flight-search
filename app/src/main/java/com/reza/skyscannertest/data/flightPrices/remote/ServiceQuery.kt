package com.reza.skyscannertest.data.flightPrices.remote

import com.google.gson.annotations.SerializedName

data class ServiceQuery(
    @SerializedName("DateTime")
    val dateTime: String?
)
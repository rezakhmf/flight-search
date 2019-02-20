package com.reza.skyscannertest.data.flightPrices.remote

import com.google.gson.annotations.SerializedName

data class FlightNumber(
    @SerializedName("CarrierId")
    val carrierId: Int?,
    @SerializedName("FlightNumber")
    val flightNumber: String?
)
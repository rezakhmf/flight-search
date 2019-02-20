package com.reza.skyscannertest.data.flightPrices.remote

import com.google.gson.annotations.SerializedName

data class BookingDetailsLink(
    @SerializedName("Body")
    val body: String?,
    @SerializedName("Method")
    val method: String?,
    @SerializedName("Uri")
    val uri: String?
)
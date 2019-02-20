package com.reza.skyscannertest.data.flightPrices.remote

import com.google.gson.annotations.SerializedName

data class PricingOption(
    @SerializedName("Agents")
    val agents: List<Int>?,
    @SerializedName("DeeplinkUrl")
    val deeplinkUrl: String?,
    @SerializedName("Price")
    val price: Double?,
    @SerializedName("QuoteAgeInMinutes")
    val quoteAgeInMinutes: Int?
)
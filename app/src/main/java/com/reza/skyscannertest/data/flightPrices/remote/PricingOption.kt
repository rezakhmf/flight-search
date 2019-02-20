package com.reza.skyscannertest.data.flightPrices.remote

data class PricingOption(
    val Agents: List<Int>?,
    val DeeplinkUrl: String?,
    val Price: Double?,
    val QuoteAgeInMinutes: Int?
)
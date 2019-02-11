package com.reza.skyscannertest.data.flightPrices.remote

data class Query(
    val Adults: Int,
    val CabinClass: String,
    val Children: Int,
    val Country: String,
    val Currency: String,
    val DestinationPlace: String,
    val GroupPricing: Boolean,
    val InboundDate: String,
    val Infants: Int,
    val Locale: String,
    val LocationSchema: String,
    val OriginPlace: String,
    val OutboundDate: String
)
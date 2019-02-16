package com.reza.skyscannertest.data.flightPrices.remote

import retrofit2.http.Query

data class Query(

    val CabinClass: String?,
    val Country: String?,
    val Currency: String?,
    val Locale: String?,
    val LocationSchema: String?,
    val OriginPlace: String?,
    val DestinationPlace: String?,
    val OutboundDate: String?,
    val InboundDate: String?,
    val Adults: Int?,
    val Children: Int?,
    val Infants: Int?,
    val GroupPricing: Boolean?
)

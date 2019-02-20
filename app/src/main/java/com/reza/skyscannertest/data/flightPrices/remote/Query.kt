package com.reza.skyscannertest.data.flightPrices.remote

import com.google.gson.annotations.SerializedName
import retrofit2.http.Query

data class Query(

    @SerializedName("CabinClass")
    val cabinClass: String?,
    @SerializedName("Country")
    val country: String?,
    @SerializedName("Currency")
    val currency: String?,
    @SerializedName("Locale")
    val locale: String?,
    @SerializedName("LocationSchema")
    val locationSchema: String?,
    @SerializedName("OriginPlace")
    val originPlace: String?,
    @SerializedName("DestinationPlace")
    val destinationPlace: String?,
    @SerializedName("OutboundDate")
    val outboundDate: String?,
    @SerializedName("InboundDate")
    val inboundDate: String?,
    @SerializedName("Adults")
    val adults: Int?,
    @SerializedName("Children")
    val children: Int?,
    @SerializedName("Infants")
    val infants: Int?,
    @SerializedName("GroupPricing")
    val groupPricing: Boolean?
)

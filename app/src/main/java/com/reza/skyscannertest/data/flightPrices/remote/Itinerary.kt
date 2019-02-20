package com.reza.skyscannertest.data.flightPrices.remote

import com.google.gson.annotations.SerializedName

data class Itinerary(
    @SerializedName("BookingDetailsLink")
    val bookingDetailsLink: BookingDetailsLink?,
    @SerializedName("InboundLegId")
    val inboundLegId: String?,
    @SerializedName("OutboundLegId")
    val outboundLegId: String?,
    @SerializedName("PricingOptions")
    val pricingOptions: List<PricingOption>?
)
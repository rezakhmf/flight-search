package com.reza.skyscannertest.data.flightPrices.remote

data class Itinerary(
    val BookingDetailsLink: BookingDetailsLink,
    val InboundLegId: String,
    val OutboundLegId: String,
    val PricingOptions: List<PricingOption>
)
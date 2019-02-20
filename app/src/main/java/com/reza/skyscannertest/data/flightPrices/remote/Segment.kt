package com.reza.skyscannertest.data.flightPrices.remote

import com.google.gson.annotations.SerializedName

data class Segment(
    @SerializedName("ArrivalDateTime")
    val arrivalDateTime: String?,
    @SerializedName("Carrier")
    val carrier: Int?,
    @SerializedName("DepartureDateTime")
    val departureDateTime: String?,
    @SerializedName("DestinationStation")
    val destinationStation: Int?,
    @SerializedName("Directionality")
    val directionality: String?,
    @SerializedName("Duration")
    val duration: Int?,
    @SerializedName("FlightNumber")
    val flightNumber: String?,
    @SerializedName("Id")
    val id: Int?,
    @SerializedName("JourneyMode")
    val journeyMode: String?,
    @SerializedName("OperatingCarrier")
    val operatingCarrier: Int?,
    @SerializedName("OriginStation")
    val originStation: Int?
)
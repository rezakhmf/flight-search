package com.reza.skyscannertest.data.flightPrices.remote

import com.google.gson.annotations.SerializedName

data class Leg(
    @SerializedName("Arrival")
    val arrival: String?,
    @SerializedName("Carriers")
    val carriers: List<Int>?,
    @SerializedName("Departure")
    val departure: String?,
    @SerializedName("DestinationStation")
    val destinationStation: Int?,
    @SerializedName("Directionality")
    val directionality: String?,
    @SerializedName("Duration")
    val duration: Int?,
    @SerializedName("FlightNumbers")
    val flightNumbers: List<FlightNumber>?,
    @SerializedName("Id")
    val id: String?,
    @SerializedName("JourneyMode")
    val journeyMode: String?,
    @SerializedName("OperatingCarriers")
    val operatingCarriers: List<Int>?,
    @SerializedName("OriginStation")
    val originStation: Int?,
    @SerializedName("SegmentIds")
    val segmentIds: List<Int>?,
    @SerializedName("Stops")
    val stops: List<Int>?
)
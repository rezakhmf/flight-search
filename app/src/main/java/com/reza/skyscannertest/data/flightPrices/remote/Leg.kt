package com.reza.skyscannertest.data.flightPrices.remote

data class Leg(
    val Arrival: String?,
    val Carriers: List<Int>?,
    val Departure: String?,
    val DestinationStation: Int?,
    val Directionality: String?,
    val Duration: Int?,
    val FlightNumbers: List<FlightNumber>?,
    val Id: String?,
    val JourneyMode: String?,
    val OperatingCarriers: List<Int>?,
    val OriginStation: Int?,
    val SegmentIds: List<Int>?,
    val Stops: List<Int>?
)
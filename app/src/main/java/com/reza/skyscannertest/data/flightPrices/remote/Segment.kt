package com.reza.skyscannertest.data.flightPrices.remote

data class Segment(
    val ArrivalDateTime: String,
    val Carrier: Int,
    val DepartureDateTime: String,
    val DestinationStation: Int,
    val Directionality: String,
    val Duration: Int,
    val FlightNumber: String,
    val Id: Int,
    val JourneyMode: String,
    val OperatingCarrier: Int,
    val OriginStation: Int
)
package com.reza.skyscannertest.data.flightPrices.local

data class FlightInfo(
    var carrier: String? = "",
    var directionality: String? = "",
    var departureTime: String? = "",
    var arrivalTime: String? = "",
    var departurePlace: String? = "",
    var arrivalPlace: String? = "",
    var stops: String? = "",
    var duration: String? = "")
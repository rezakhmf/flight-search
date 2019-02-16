package com.reza.skyscannertest.data.flightPrices.remote

data class FlightPricesResults(
    val Agents: List<Agent>?,
    val Carriers: List<Carrier>?,
    val Currencies: List<Currency>?,
    val Itineraries: List<Itinerary>?,
    val Legs: List<Leg>?,
    val Places: List<Place>?,
    val Query: Query?,
    val Segments: List<Segment>?,
    val ServiceQuery: ServiceQuery?,
    val SessionKey: String?,
    val Status: String?
)
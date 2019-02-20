package com.reza.skyscannertest.data.flightPrices.remote

import com.google.gson.annotations.SerializedName

data class FlightPricesResults(
    @SerializedName("Agents")
    val agents: List<Agent>?,
    @SerializedName("Carriers")
    val carriers: List<Carrier>?,
    @SerializedName("Currencies")
    val currencies: List<Currency>?,
    @SerializedName("Itineraries")
    val itineraries: List<Itinerary>?,
    @SerializedName("Legs")
    val legs: List<Leg>?,
    @SerializedName("Places")
    val places: List<Place>?,
    @SerializedName("Query")
    val query: Query?,
    @SerializedName("Segments")
    val segments: List<Segment>?,
    @SerializedName("ServiceQuery")
    val serviceQuery: ServiceQuery?,
    @SerializedName("SessionKey")
    val sessionKey: String?,
    @SerializedName("Status")
    val status: String?
)
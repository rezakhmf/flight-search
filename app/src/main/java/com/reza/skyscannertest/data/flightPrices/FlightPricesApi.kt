package com.reza.skyscannertest.data.flightPrices

import com.reza.skyscannertest.data.flightPrices.remote.FlightPricesResults
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Url

interface FlightPricesApi {

    @POST
    fun createSesion(@Query("cabinclass") cabinClass: String,
                     @Query("country") country: String,
                     @Query("currency") currency: String,
                     @Query("locale") locale: String,
                     @Query("locationSchema") locationSchema: String,
                     @Query("originplace") originplace: String,
                     @Query("destinationplace") destinationplace: String,
                     @Query("outbounddate") outbounddate: String,
                     @Query("inbounddate") inbounddate: String,
                     @Query("adults") adults: Int,
                     @Query("children") children: Int,
                     @Query("infants") infants: Int) : Observable<String>
    @GET
    fun getFlightPrices(@Url url: String) : Observable<FlightPricesResults>
}
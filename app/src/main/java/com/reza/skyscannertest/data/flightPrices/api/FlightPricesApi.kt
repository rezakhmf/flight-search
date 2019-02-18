package com.reza.skyscannertest.data.flightPrices.api

import com.google.gson.JsonObject
import com.reza.skyscannertest.data.flightPrices.remote.FlightPricesResults
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*

interface FlightPricesApi {

    @FormUrlEncoded
    @POST
    fun createSession(@Url url: String, @Field("cabinclass") cabinClass: String,
                      @Field("country") country: String,
                      @Field("currency") currency: String,
                      @Field("locale") locale: String,
                      @Field("locationSchema") locationSchema: String,
                      @Field("originplace") originplace: String,
                      @Field("destinationplace") destinationplace: String,
                      @Field("outbounddate") outbounddate: String,
                      @Field("inbounddate") inbounddate: String,
                      @Field("adults") adults: Int,
                      @Field("children") children: Int,
                      @Field("infants") infants: Int
                     ) : Observable<Response<JsonObject>>
    @GET
    fun getFlightPrices(@Url url: String) : Observable<FlightPricesResults>
}


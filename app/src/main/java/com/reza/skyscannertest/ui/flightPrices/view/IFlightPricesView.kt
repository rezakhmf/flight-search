package com.reza.skyscannertest.ui.flightPrices.view

import com.reza.skyscannertest.data.flightPrices.local.FlightInfo
import com.reza.skyscannertest.data.flightPrices.remote.FlightPricesResults
import java.util.ArrayList

interface IFlightPricesView {

    fun showFlightPrices(flightsInfo: MutableList<FlightInfo>)
    fun loadingStarted()
    fun loadingFailed(errorMessage: String?)
}
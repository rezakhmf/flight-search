package com.reza.skyscannertest.ui.flightPrices.view

import com.reza.skyscannertest.data.flightPrices.remote.FlightPricesResults
import java.util.ArrayList

interface IFlightPricesView {

    fun showAccount(flightPrices: FlightPricesResults)
    fun loadingStarted()
    fun loadingFailed(errorMessage: String?)
}
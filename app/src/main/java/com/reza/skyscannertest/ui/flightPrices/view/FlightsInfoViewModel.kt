package com.reza.skyscannertest.ui.flightPrices.view

import android.arch.lifecycle.ViewModel
import com.reza.skyscannertest.data.flightPrices.local.FlightInfo

class FlightsInfoViewModel: ViewModel() {

    var flightInfo: MutableList<FlightInfo>? = null
}
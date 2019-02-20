package com.reza.skyscannertest.ui.flightPrices.presenter

import com.reza.skyscannertest.ui.flightPrices.view.IFlightPricesView

interface IFlightPricesPresenter {
    fun createFlightPricesSession()
    fun getFlightPricesSession(url: String)

    fun setView(flighPricesView: IFlightPricesView)

    fun destroy()
}
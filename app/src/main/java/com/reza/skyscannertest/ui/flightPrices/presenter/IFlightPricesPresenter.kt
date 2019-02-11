package com.reza.skyscannertest.ui.flightPrices.presenter

import com.reza.skyscannertest.ui.flightPrices.view.IFlightPricesView

interface IFlightPricesPresenter {
    fun displayFlightPrices()

    fun setView(flighPricesView: IFlightPricesView)

    fun destroy()
}
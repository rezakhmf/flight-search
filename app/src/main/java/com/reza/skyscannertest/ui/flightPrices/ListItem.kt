package com.reza.skyscannertest.ui.flightPrices

abstract class ListItem {

    abstract val type: Int

    companion object {

        val TYPE_FLIGHT_INFO = 0
        val TYPE_SUMMARY = 1
    }

}
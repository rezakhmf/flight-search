package com.reza.skyscannertest.di.module.flightPrices

import com.reza.skyscannertest.ui.flightPrices.view.FlightPricesActivity
import dagger.Module
import dagger.Provides


@Module
class FlightPricesActivityModule {

    @Provides
    fun bindFlightPricesActivity(flightPricesActivity: FlightPricesActivity): FlightPricesActivity {
        return FlightPricesActivity()
    }

}
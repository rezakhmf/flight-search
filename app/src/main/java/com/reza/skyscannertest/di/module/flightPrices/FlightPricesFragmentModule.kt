package com.reza.skyscannertest.di.module.flightPrices

import com.reza.skyscannertest.ui.flightPrices.view.FlightPricesFragment
import dagger.Module
import dagger.Provides

@Module
class FlightPricesFragmentModule {

    @Provides
    fun provideFlightPricesFragment(flightPricesFragment: FlightPricesFragment) : FlightPricesFragment{
        return flightPricesFragment
    }
}
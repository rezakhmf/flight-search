package com.reza.skyscannertest.di.module.flightPrices

import com.reza.skyscannertest.di.scope.FragmentScope
import com.reza.skyscannertest.ui.base.BaseFragment
import com.reza.skyscannertest.ui.flightPrices.view.FlightPricesFragment
import com.reza.skyscannertest.ui.flightPrices.view.IFlightPricesView
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
class FlightPricesFragmentModule {


//    private lateinit var flightPricesFragment: FlightPricesFragment
//
//    constructor(flightPricesFragment: FlightPricesFragment) {
//        this.flightPricesFragment = flightPricesFragment
//    }

    @Provides
    fun provideFlightPricesFragment() : FlightPricesFragment {
        return FlightPricesFragment()
    }

}
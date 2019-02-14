package com.reza.skyscannertest.di.module

import dagger.Module
import com.reza.skyscannertest.ui.flightPrices.view.FlightPricesActivity
import com.reza.skyscannertest.di.module.flightPrices.FlightPricesActivityModule
import com.reza.skyscannertest.di.module.flightPrices.FlightPricesFragmentProvider
import com.reza.skyscannertest.ui.flightPrices.view.FlightPricesFragment
import dagger.android.ContributesAndroidInjector



@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [FlightPricesActivityModule::class, FlightPricesFragmentProvider::class])
    public abstract fun bindFlightPricesActivity(): FlightPricesActivity


}
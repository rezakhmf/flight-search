package com.reza.skyscannertest.di.module

import dagger.Module
import com.reza.skyscannertest.ui.flightPrices.view.FlightPricesActivity
import com.reza.skyscannertest.di.module.flightPrices.FlightPricesActivityModule
import com.reza.skyscannertest.di.module.flightPrices.FlightPricesFragmentModule
import dagger.android.ContributesAndroidInjector



@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [FlightPricesActivityModule::class, FlightPricesFragmentModule::class])
    internal abstract fun bindFlightPricesActivity(): FlightPricesActivity
}
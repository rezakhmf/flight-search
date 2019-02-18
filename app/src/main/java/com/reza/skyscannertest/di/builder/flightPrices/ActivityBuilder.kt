package com.reza.skyscannertest.di.builder.flightPrices

import dagger.Module
import com.reza.skyscannertest.ui.flightPrices.view.FlightPricesActivity
import com.reza.skyscannertest.di.module.flightPrices.FlightPricesActivityModule
import com.reza.skyscannertest.di.module.flightPrices.FlightPricesFragmentModule
import com.reza.skyscannertest.ui.flightPrices.view.FlightPricesFragment
import dagger.android.ContributesAndroidInjector



@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [FlightPricesActivityModule::class])
    abstract fun bindFlightPricesActivity(): FlightPricesActivity

    @ContributesAndroidInjector(modules = [FlightPricesFragmentModule::class])
    public abstract fun flightPricesFragmentInject(): FlightPricesFragment

}
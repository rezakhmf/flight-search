package com.reza.skyscannertest.di.module.flightPrices

import com.reza.skyscannertest.data.flightPrices.FlightPricesApi
import com.reza.skyscannertest.di.scope.FragmentScope
import com.reza.skyscannertest.ui.flightPrices.FlightPricesRVAdapter
import com.reza.skyscannertest.ui.flightPrices.presenter.FlightPricesPresenter
import com.reza.skyscannertest.ui.flightPrices.presenter.IFlightPricesPresenter
import com.reza.skyscannertest.ui.flightPrices.view.FlightPricesFragment
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
internal class FlightPricesActivityModule {

    @Provides
    fun provideFlightPricesPresenter(flightPricesApi: FlightPricesApi) : IFlightPricesPresenter {
        return FlightPricesPresenter(flightPricesApi)
    }

    @Provides
    fun provideFlightPricesApi(retrofit: Retrofit) : FlightPricesApi {
        return retrofit.create(FlightPricesApi::class.java)
    }

    @Provides
    fun provideFlightPricesRVAdapter() : FlightPricesRVAdapter {
        return FlightPricesRVAdapter()
    }

}
package com.reza.skyscannertest.di.module.flightPrices

import com.reza.skyscannertest.data.flightPrices.api.FlightPricesApi
import com.reza.skyscannertest.ui.flightPrices.adapter.FlightPricesRVAdapter
import com.reza.skyscannertest.ui.flightPrices.presenter.FlightPricesPresenter
import com.reza.skyscannertest.ui.flightPrices.presenter.IFlightPricesPresenter
import com.reza.skyscannertest.ui.flightPrices.presenter.biz.FlightInfoBiz
import com.reza.skyscannertest.ui.flightPrices.view.FlightPricesFragment
import com.reza.skyscannertest.ui.flightPrices.view.IFlightPricesView
import dagger.Module
import dagger.Provides

@Module
class FlightPricesFragmentModule {

    @Provides
    fun provideFlightPricesPresenter(flightPricesApi: FlightPricesApi) : IFlightPricesPresenter {
        return FlightPricesPresenter(flightPricesApi)
    }

    @Provides
    fun provideFlightPricesRVAdapter() : FlightPricesRVAdapter {
        return FlightPricesRVAdapter()
    }

    @Provides
    fun flightPricesFragmentView(flightPricesFragment: FlightPricesFragment): IFlightPricesView {
        return flightPricesFragment
    }

    @Provides
    fun flightInfoBizPresenter(): FlightInfoBiz{
        return FlightInfoBiz()
    }

}
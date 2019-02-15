package com.reza.skyscannertest.di.module.flightPrices

import com.reza.skyscannertest.data.flightPrices.FlightPricesApi
import com.reza.skyscannertest.di.scope.FragmentScope
import com.reza.skyscannertest.ui.flightPrices.FlightPricesRVAdapter
import com.reza.skyscannertest.ui.flightPrices.presenter.FlightPricesPresenter
import com.reza.skyscannertest.ui.flightPrices.presenter.IFlightPricesPresenter
import com.reza.skyscannertest.ui.flightPrices.view.FlightPricesActivity
import com.reza.skyscannertest.ui.flightPrices.view.FlightPricesFragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import retrofit2.Retrofit
import dagger.Binds



@Module
class FlightPricesActivityModule {



    @Provides
    fun bindFlightPricesActivity(flightPricesActivity: FlightPricesActivity): FlightPricesActivity {
        return FlightPricesActivity()
    }

}
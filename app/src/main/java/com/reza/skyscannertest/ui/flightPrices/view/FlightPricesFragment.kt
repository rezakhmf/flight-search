package com.reza.skyscannertest.ui.flightPrices.view

import android.content.Context
import android.os.Bundle
import android.provider.Contacts
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reza.skyscannertest.R
import com.reza.skyscannertest.data.flightPrices.remote.FlightPricesResults
import com.reza.skyscannertest.ui.base.BaseFragment
import com.reza.skyscannertest.ui.flightPrices.FlightPricesRVAdapter
import com.reza.skyscannertest.ui.flightPrices.presenter.FlightPricesPresenter
import com.reza.skyscannertest.utils.extensions.visible
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.flight_prices_fragment.*
import javax.inject.Inject

class FlightPricesFragment: BaseFragment(), IFlightPricesView {


//    @Inject
//    lateinit var flightPricesPresenter: FlightPricesPresenter
//    @Inject
//    lateinit var flightPricesRVAdapter: FlightPricesRVAdapter

    override fun layoutId() = R.layout.flight_prices_fragment


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        initializeView()
//        loadReposList()
//    }
//
//    private fun initializeView() {
//        with(flightPricesRV) {
//            setHasFixedSize(true)
//            adapter = flightPricesRVAdapter
//        }
//    }
//
//    private fun loadReposList() {
//        emptyView.invalidate()
//        flightPricesRV.visible()
//        showProgress()
//        // should get price list from here from peresenter need to fix all injection
//        //flightPricesPresenter.displayFlightPrices()
//    }


    override fun showFlightPrices(flightPrices: FlightPricesResults) {
        // connect to recycleview
    }

    override fun loadingStarted() {

    }

    override fun loadingFailed(errorMessage: String?) {

    }

}
package com.reza.skyscannertest.ui.flightPrices.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.reza.skyscannertest.R
import com.reza.skyscannertest.data.flightPrices.local.FlightInfo
import com.reza.skyscannertest.ui.base.BaseFragment
import com.reza.skyscannertest.ui.flightPrices.adapter.FlightPricesRVAdapter
import com.reza.skyscannertest.ui.flightPrices.presenter.FlightPricesPresenter
import com.reza.skyscannertest.utils.extensions.invisible
import com.reza.skyscannertest.utils.extensions.visible
import kotlinx.android.synthetic.main.flight_prices_fragment.*
import javax.inject.Inject

class FlightPricesFragment @Inject constructor() : BaseFragment(), IFlightPricesView {


    @Inject
    lateinit var flightPricesPresenter: FlightPricesPresenter
    @Inject
    lateinit var flightPricesRVAdapter: FlightPricesRVAdapter

    override fun layoutId() = R.layout.flight_prices_fragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        flightPricesPresenter?.setView(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showProgress()
        initializeView()
        flightPricesPresenter.createFlightPricesSession()

        //loadReposList()
    }

    private fun initializeView() {
        emptyView.visible()
        with(flightPricesRV) {
            setHasFixedSize(true)
            adapter = flightPricesRVAdapter
            layoutManager = LinearLayoutManager(activity)


        }
//
//        flightPricesRVAdapter?.reloadFlightPrices()
    }

    private fun loadReposList() {
        emptyView.invalidate()
        flightPricesRV.visible()
       // showProgress()
        // should get price list from here from peresenter need to fix all injection
        //flightPricesPresenter.createFlightPricesSession()
    }


    override fun showFlightPrices(flightPrices: MutableList<FlightInfo>) {
        // connect to recycleview
        flightPricesRVAdapter?.reloadFlightPrices(flightPrices)

        print(flightPrices)
        with(flightPricesRV) {
            setHasFixedSize(true)
            adapter = flightPricesRVAdapter
            layoutManager = LinearLayoutManager(activity)
            emptyView.invisible()
        }

    }

    override fun loadingStarted() {
        print("loading Started")
    }

    override fun loadingFailed(errorMessage: String?) {

    }

}
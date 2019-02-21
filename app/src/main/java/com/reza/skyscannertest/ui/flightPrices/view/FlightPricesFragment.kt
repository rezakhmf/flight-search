package com.reza.skyscannertest.ui.flightPrices.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reza.skyscannertest.R
import com.reza.skyscannertest.data.flightPrices.local.FlightInfo
import com.reza.skyscannertest.ui.base.BaseFragment
import com.reza.skyscannertest.ui.flightPrices.adapter.FlightPricesRVAdapter
import com.reza.skyscannertest.ui.flightPrices.presenter.FlightPricesPresenter
import com.reza.skyscannertest.utils.extensions.invisible
import com.reza.skyscannertest.utils.extensions.visible
import kotlinx.android.synthetic.main.flight_prices_fragment.*
import kotlinx.android.synthetic.main.flight_prices_fragment.view.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbar.view.*
import javax.inject.Inject
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class FlightPricesFragment @Inject constructor() : BaseFragment(), IFlightPricesView {

    @Inject
    lateinit var flightPricesPresenter: FlightPricesPresenter
    @Inject
    lateinit var flightPricesRVAdapter: FlightPricesRVAdapter

    override fun layoutId() = com.reza.skyscannertest.R.layout.flight_prices_fragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        flightPricesPresenter?.setView(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(layoutId(), container, false)

        with(view.flightPricesRV) {
            setHasFixedSize(true)
            val manager = LinearLayoutManager(context)
            layoutManager = manager
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        showProgress()
    }

    private fun initializeView() {
        emptyView.visible()

        flightPricesPresenter.createFlightPricesSession()
        flightPricesRV.visible()
    }


    override fun showFlightPrices(flightPrices: MutableList<FlightInfo>) {
        flightPricesRVAdapter?.reloadFlightPrices(flightPrices)

//        val act = activity as AppCompatActivity?
//        if (act!!.supportActionBar != null) {
//           // val toolbar = act.supportActionBar!!.customView as Toolbar
//            doAsync {
//                uiThread {
//                    toolbarFromTo.text = "BUD - London"
//                }
//            }
//
//        }

        sortFilter.text = "Sort & Filter"
        pagingResult.text = flightPrices.size.toString() + " resutls"
        flightPricesRV.recycledViewPool.setMaxRecycledViews(0,20)
        flightPricesRV.adapter = flightPricesRVAdapter
        flightPricesRVAdapter?.notifyDataSetChanged()
        emptyView.invisible()
        hideProgress()
    }

    override fun loadingStarted() {
        notify("loading...")
    }

    override fun loadingFailed(errorMessage: String?) {
        notify(errorMessage.toString())
    }

}
package com.reza.skyscannertest.ui.flightPrices.view

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView.HORIZONTAL
import android.support.v7.widget.RecyclerView.VERTICAL
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(layoutId(), container, false)


        with(view.flightPricesRV) {
            setHasFixedSize(true)
            val manager = LinearLayoutManager(context)
            layoutManager = manager
            val dividerItemDecoration = DividerItemDecoration(context, HORIZONTAL)
            dividerItemDecoration.setDrawable(context.getDrawable(R.drawable.border))
            addItemDecoration(dividerItemDecoration)
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
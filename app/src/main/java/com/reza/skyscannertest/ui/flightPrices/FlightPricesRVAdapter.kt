package com.reza.skyscannertest.ui.flightPrices

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reza.skyscannertest.R
import com.reza.skyscannertest.data.flightPrices.local.FlightInfo
import kotlinx.android.synthetic.main.flight_price_item.view.*
import java.util.*
import javax.inject.Inject

class FlightPricesRVAdapter@Inject constructor(): RecyclerView.Adapter<FlightPricesRVAdapter.FlightViewHolder>() {

    private var context: Context? = null
    private var flightPrices = Collections.emptyList<FlightInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightPricesRVAdapter.FlightViewHolder {
        context = parent?.context
        val layoutInflater = LayoutInflater.from(context)

        return FlightViewHolder(layoutInflater.inflate(R.layout.flight_price_item, parent, false))
    }

    override fun getItemCount(): Int {
        return  flightPrices.size
    }

    override fun onBindViewHolder(holder: FlightViewHolder, int: Int) {
        holder.itemView.flightTime.text = "reza test"

    }


    fun reloadFlightPrices(flightPrices: MutableList<FlightInfo>){

        this.flightPrices = flightPrices
    }




    class FlightViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val flighTime = view.flightTime
    }
}
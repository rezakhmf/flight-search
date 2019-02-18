package com.reza.skyscannertest.ui.flightPrices.adapter

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        context = parent?.context
        val layoutInflater = LayoutInflater.from(context)

        return FlightViewHolder(
            layoutInflater.inflate(
                R.layout.flight_price_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return  flightPrices.size
    }

    override fun onBindViewHolder(holder: FlightViewHolder, postion: Int) {

        val flightInfo = flightPrices.get(postion)

        holder.itemView.flightTime.text = flightInfo.departureTime + flightInfo.departureTime
        holder.itemView.flightInOutBound.text = flightInfo.departurePlace  + "-" + flightInfo.arrivalPlace
        holder.itemView.flightStops.text = flightInfo.directionality
        holder.itemView.flightDuration.text = "need to be fixed"

        // TODO(replace with calculated)
        holder.itemView.flightPoint.text = "10"
        holder.itemView.flightProvider.text = flightInfo.carrier
        holder.itemView.flightPrice.text = "35"


    }


    fun reloadFlightPrices(flightPrices: MutableList<FlightInfo>){

        this.flightPrices = flightPrices
    }




    class FlightViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val flighTime = view.flightTime
        val flightInOutBound = view.flightInOutBound
        val flightStops = view.flightStops
        val flightDuration = view.flightDuration

        val flightPoint = view.flightPoint
        val flightProvider = view.flightProvider
        val flightPrice = view.flightPrice
    }
}
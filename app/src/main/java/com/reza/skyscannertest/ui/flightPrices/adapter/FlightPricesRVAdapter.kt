package com.reza.skyscannertest.ui.flightPrices.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reza.skyscannertest.R
import com.reza.skyscannertest.data.flightPrices.local.FlightInfo
import kotlinx.android.synthetic.main.flghit_feedback_price_item.view.*
import kotlinx.android.synthetic.main.flight_price_item.view.*
import kotlinx.android.synthetic.main.flight_prices_fragment.view.*
import java.util.*
import javax.inject.Inject

class FlightPricesRVAdapter @Inject constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var context: Context? = null
    private var flightPrices = Collections.emptyList<FlightInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        context = parent?.context
        val layoutInflater = LayoutInflater.from(context)

        when (viewType) {
            ListItem.TYPE_FLIGHT_INFO -> {
                val itemView = layoutInflater.inflate(R.layout.flight_price_item, parent, false)
                return FlightPriceItemViewHolder(itemView)
            }

            ListItem.TYPE_FEEDBACK -> {
                val itemView = layoutInflater.inflate(R.layout.flghit_feedback_price_item, parent, false)
                return FlightFeedbackViewHolder(itemView)
            }

            else -> throw IllegalStateException("unsupported view type")
        }
    }


    override fun getItemCount(): Int {
        return flightPrices.size
    }

    override fun getItemViewType(position: Int): Int {
        if ((position+1) % 3 != 0) {
            return ListItem.TYPE_FLIGHT_INFO
        }
        if ((position+1) % 3 == 0) {
            return ListItem.TYPE_FEEDBACK
        }
        return ListItem.TYPE_FEEDBACK
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val flightInfo = flightPrices.get(position)
        val viewType = getItemViewType(position)

        when (viewType) {
            ListItem.TYPE_FLIGHT_INFO -> {
                holder.itemView.flightTime.text = flightInfo.departureTime + "-" + flightInfo.arrivalTime
                holder.itemView.flightInOutBound.text = flightInfo.departurePlace + "-" + flightInfo.arrivalPlace
                holder.itemView.flightStops.text = flightInfo.stops
                holder.itemView.flightDuration.text = flightInfo.duration
            }
            ListItem.TYPE_FEEDBACK -> {
                // TODO(replace with calculated)
                holder.itemView.flightPoint.text = "10.0"
                holder.itemView.flightProvider.text = flightInfo.carrier
                holder.itemView.flightPrice.text = "£35"
            }
        }
    }


    fun reloadFlightPrices(flightPrices: MutableList<FlightInfo>) {
        this.flightPrices.clear()
        this.flightPrices = flightPrices
    }


    class FlightPriceItemViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val flightTime = itemView.flightTime
        val flightInOutBound = itemView.flightInOutBound
        val flightStops = itemView.flightStops
        val flightDuration = itemView.flightDuration
    }

    class FlightFeedbackViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val flightPoint = itemView.flightPoint
        val flightProvider = itemView.flightProvider
        val flightPrice = itemView.flightPrice
    }

}
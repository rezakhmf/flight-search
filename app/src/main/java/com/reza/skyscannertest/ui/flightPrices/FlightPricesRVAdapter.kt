package com.reza.skyscannertest.ui.flightPrices

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reza.skyscannertest.R
import javax.inject.Inject

class FlightPricesRVAdapter@Inject constructor(): RecyclerView.Adapter<FlightPricesRVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.flight_price_item, parent, false))
    }

    override fun getItemCount(): Int {
        return  0
    }

    override fun onBindViewHolder(holder: ViewHolder, int: Int) {
        //set view groups get from bank transaction
    }



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}
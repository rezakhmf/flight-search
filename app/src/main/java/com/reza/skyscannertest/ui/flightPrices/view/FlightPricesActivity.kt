package com.reza.skyscannertest.ui.flightPrices.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.reza.skyscannertest.R
import com.reza.skyscannertest.ui.base.BaseActivity
import com.reza.skyscannertest.utils.extensions.addFragment
import dagger.android.DaggerActivity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject


class FlightPricesActivity : BaseActivity() {

    @Inject
    lateinit var flightPricesFragment: FlightPricesFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flight_price_list)

        setSupportActionBar(toolbar)

        addFragment(flightPricesFragment, R.id.flightPricesContainer)

    }
}

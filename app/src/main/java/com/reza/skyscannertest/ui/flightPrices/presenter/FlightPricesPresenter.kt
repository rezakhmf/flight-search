package com.reza.skyscannertest.ui.flightPrices.presenter

import com.reza.skyscannertest.data.flightPrices.FlightPricesApi
import com.reza.skyscannertest.data.flightPrices.remote.FlightPricesResults
import com.reza.skyscannertest.ui.flightPrices.view.IFlightPricesView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class FlightPricesPresenter(flightPricesApi: FlightPricesApi) : IFlightPricesPresenter {


    private var flightPricesApi: FlightPricesApi = flightPricesApi
    private var flighPricesView: IFlightPricesView? = null
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun displayFlightPrices() {
        var disposableFlightPrices = flightPricesApi?.createSesion("Economy", "UK",
            "GBP", "en-GB",
            "iata", "EDI",
            "LHR", "2019-02-11",
            "2019-02-12", 1, 0, 0)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe{
                if(isViewAttached()) {
                    flighPricesView?.loadingStarted()
                }
            }.subscribeBy( onNext = { flightPrices ->

            },
                onError = { error ->

                },
                onComplete = {})
    }

    override fun setView(flighPricesView: IFlightPricesView) {
        this.flighPricesView = flighPricesView
    }

    override fun destroy() {
        flighPricesView = null
        compositeDisposable?.clear()
    }

    private fun onFlightPricesResult(flightPrices: FlightPricesResults) {
        if(isViewAttached() && flightPrices != null) {
         // logic in kotlin way do async from cba
        }
    }

    private fun onFlightPricestFetchError(throwable: Throwable) {
        if (isViewAttached()) {
            flighPricesView?.loadingFailed(throwable.message)
        } else {
            // do nothing
        }
    }

    private fun isViewAttached(): Boolean {
        return flighPricesView != null
    }

}

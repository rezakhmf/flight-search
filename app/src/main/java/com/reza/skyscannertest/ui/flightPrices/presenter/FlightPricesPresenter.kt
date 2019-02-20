package com.reza.skyscannertest.ui.flightPrices.presenter

import com.reza.skyscannertest.data.flightPrices.api.FlightPricesApi
import com.reza.skyscannertest.data.flightPrices.remote.FlightPricesResults
import com.reza.skyscannertest.ui.flightPrices.presenter.biz.FlightInfoBiz
import com.reza.skyscannertest.ui.flightPrices.view.IFlightPricesView
import com.reza.skyscannertest.ui.main.PRICING_URL
import com.reza.skyscannertest.utils.extensions.NextMonday
import com.reza.skyscannertest.utils.extensions.NextTuesday
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import javax.inject.Inject

class FlightPricesPresenter @Inject constructor(flightPricesApi: FlightPricesApi) : IFlightPricesPresenter {


    @Inject
    lateinit var flightPricesInOutBound: FlightInfoBiz
    private var flightPricesApi: FlightPricesApi = flightPricesApi
    private var flightPricesView: IFlightPricesView? = null
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun createFlightPricesSession() {


        var flightPricesSession = flightPricesApi?.createSession(
            PRICING_URL, "Economy", "UK",
            "GBP", "en-GB",
            "iata", "EDI",
            "LHR", String().NextMonday(),
            String().NextTuesday(), 1, 0, 0
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                if (isViewAttached()) {
                    flightPricesView?.loadingStarted()

                }

            }.subscribeBy(
                onNext = { flightPricesSessionResponse ->
                    flightPricesSessionResponse.headers().get("location").let {
                        getFlightPricesSession(it.toString())
                    }
                },
                onError = { error ->
                    onFlightPricesFetchError(error)
                },
                onComplete = {
                    print("completed")
                })

        compositeDisposable.add(flightPricesSession)
    }

    override fun getFlightPricesSession(url: String) {

        flightPricesApi?.getFlightPrices(url)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = { flightPrices ->


                    doAsync {
                        val flightsInfo = flightPricesInOutBound.getFlightPrices(flightPrices)
                        uiThread {
                            flightPricesView?.showFlightPrices(flightsInfo)
                        }
                    }
                },
                onError = { error ->
                    onFlightPricesFetchError(error)
                },
                onComplete = {
                    print("completed")
                })

    }

    override fun setView(flightPricesView: IFlightPricesView) {
        this.flightPricesView = flightPricesView
    }

    override fun destroy() {
        flightPricesView = null
        compositeDisposable?.clear()
    }

    private fun onFlightPricesResult(flightPrices: FlightPricesResults) {
        if (isViewAttached() && flightPrices != null) {

        }
    }

    private fun onFlightPricesFetchError(throwable: Throwable) {
        if (isViewAttached()) {
            flightPricesView?.loadingFailed(throwable.message)
        } else {
            // do nothing
        }
    }

    private fun isViewAttached(): Boolean {
        return flightPricesView != null
    }

}

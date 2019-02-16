package com.reza.skyscannertest.ui.flightPrices.presenter

import com.reza.skyscannertest.data.flightPrices.FlightPricesApi
import com.reza.skyscannertest.data.flightPrices.local.FlightInfo
import com.reza.skyscannertest.data.flightPrices.remote.FlightPricesResults
import com.reza.skyscannertest.ui.flightPrices.view.IFlightPricesView
import com.reza.skyscannertest.ui.main.PRICING_URL
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FlightPricesPresenter @Inject constructor(flightPricesApi: FlightPricesApi) : IFlightPricesPresenter {


    private var flightPricesApi: FlightPricesApi = flightPricesApi
    private var flighPricesView: IFlightPricesView? = null
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun createFlightPricesSession() {


        var flightPricesSessionn = flightPricesApi?.createSession(
            PRICING_URL, "Economy", "UK",
            "GBP", "en-GB",
            "iata", "EDI",
            "LHR", "2019-02-18",
            "2019-02-19", 1, 0, 0
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                //  if(isViewAttached()) {
                flighPricesView?.loadingStarted()

                // }

            }.subscribeBy(
                onNext = { flightPricesSessionResponse ->
                    flightPricesSessionResponse.headers().get("location").let {
                        getFlightPricesSession(it.toString())
                    }
                },
                onError = { error ->
                    onFlightPricestFetchError(error)
                },
                onComplete = {
                    print("completed")
                })

        compositeDisposable.add(flightPricesSessionn)
    }

    override fun getFlightPricesSession(url: String) {

        var flightPrices = flightPricesApi?.getFlightPrices(url)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = { flightPrices ->


                    var flightInfo: FlightInfo? = FlightInfo()

                    val flightsInfo: MutableList<FlightInfo> = arrayListOf()

                    // flighPricesView?.showFlightPrices(flightPrices)

                    var legs = Observable.fromArray(flightPrices.Itineraries)
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .flatMapIterable { itineraries -> itineraries }
                        // legs
                        .flatMap { itineraries ->
                            Observable.fromArray(flightPrices.Legs)
                                .flatMapIterable { it -> it }
                                .filter { leg ->
                                    itineraries.InboundLegId == leg.Id
                                }
                                .map { leg ->
                                    flightInfo?.directionality = leg.Directionality
                                    flightInfo?.arrivalTime = leg.Arrival
                                    flightInfo?.departureTime = leg.Departure
                                    flightInfo?.stops = leg.Stops?.size
                                    flightInfo?.let {
                                        flightsInfo.add(flightInfo)
                                    }
                                    return@map leg
                                }.flatMap { leg ->
                                    Observable.fromArray(flightPrices.Segments)
                                        .flatMapIterable { it -> it }
                                        .filter { segment ->
                                            leg.SegmentIds?.get(0) == segment.Id
                                        }.map { segment ->
                                            flightInfo?.arrivalPlace = segment.Id.toString()
                                            return@map segment
                                        }
                                }
                        }.subscribeBy(
                            onNext = { flightPricesSessionResponse ->


                            },
                            onError = { error ->
                                onFlightPricestFetchError(error)
                            },
                            onComplete = {
                                print(flightsInfo)
                            })



                    Observable.fromArray(flightsInfo)
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .flatMapIterable { flightsInfo -> flightsInfo }
                        .flatMap { flightInfo ->
                            Observable.fromArray(flightPrices.Segments)
                                .flatMapIterable { it -> it }
                                .filter { segment ->
                                    flightInfo.arrivalPlace == segment.Id.toString()
                                }
                                .map { segment -> segment }
                        }.flatMap { place ->
                            Observable.fromArray(flightPrices.Places)
                                .flatMapIterable { it -> it }
                                .filter { originStation ->
                                    place.OriginStation == originStation.Id
                                }
                                .map { originStation ->
                                    flightInfo?.departurePlace = originStation.Code
                                    return@map originStation
                                }
                        }.subscribeBy(
                            onNext = { flightPricesSessionResponse ->


                            },
                            onError = { error ->
                                onFlightPricestFetchError(error)
                            },
                            onComplete = {
                                print(flightsInfo)
                            })


                    Observable.fromArray(flightsInfo)
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .flatMapIterable { flightsInfo -> flightsInfo }
                        .flatMap { flightInfo ->
                            Observable.fromArray(flightPrices.Segments)
                                .flatMapIterable { it -> it }
                                .filter { segment ->
                                    flightInfo.arrivalPlace == segment.Id.toString()
                                }
                                .map { segment -> segment }
                        }.flatMap { carrier ->
                            Observable.fromArray(flightPrices.Carriers)
                                .flatMapIterable { it -> it }
                                .filter { carrierName ->
                                    carrier.Carrier == carrierName.Id
                                }
                                .map { carrier ->
                                    flightInfo?.carrier = carrier.Name
                                    return@map carrier
                                }
                        }.subscribeBy(
                            onNext = { flightPricesSessionResponse ->


                            },
                            onError = { error ->
                                onFlightPricestFetchError(error)
                            },
                            onComplete = {
                                print(flightsInfo)
                            })



                    Observable.fromArray(flightsInfo)
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .flatMapIterable { flightsInfo -> flightsInfo }
                        .flatMap { flightInfo ->
                            Observable.fromArray(flightPrices.Segments)
                                .flatMapIterable { it -> it }
                                .filter { segment ->
                                    flightInfo.arrivalPlace == segment.Id.toString()
                                }
                                .map { segment -> segment }
                        }.flatMap { place ->
                            Observable.fromArray(flightPrices.Places)
                                .flatMapIterable { it -> it }
                                .filter { originStation ->
                                    place.DestinationStation == originStation.Id
                                }
                                .map { destinationStation ->
                                    flightInfo?.arrivalPlace = destinationStation.Code
                                    return@map destinationStation
                                }
                        }.subscribeBy(
                            onNext = { flightPricesSessionResponse ->


                            },
                            onError = { error ->
                                onFlightPricestFetchError(error)
                            },
                            onComplete = {
                                print(flightsInfo)
                            })






                    // segment
//                    var segment = legs.flatMap { leg ->  Observable.fromArray(flightPrices.Segments)
//                            .flatMapIterable { it -> it }
//                            .filter { segment ->
//                                leg.SegmentIds?.get(0) == segment.Id}
//
//                        }

                    // originStation
//                        segment.flatMap { place ->  Observable.fromArray(flightPrices.Places)
//                            .flatMapIterable { it -> it }
//                            .filter { originStation ->
//                                place.OriginStation == originStation.Id }
//                            .map { originStation ->
//                                flightInfo?.departurePlace = originStation.Name
//                                return@map originStation
//                            }
//                        }


//                        // segment
//                        .flatMap { leg ->  Observable.fromArray(flightPrices.Segments)
//                            .flatMapIterable { it -> it }
//                            .filter { segment -> leg.SegmentIds?.get(0) == segment.Id}
//
//                        }
//                        // places
//                        .flatMap { _segment ->  Observable.fromArray(flightPrices.Places)
//                            .flatMapIterable { it -> it }
//                            .filter { originStation ->  _segment.OriginStation == originStation.Id }
//                            .map { originStation ->
//                                flightInfo?.departurePlace = originStation.Name
//                                return@map originStation
//                            }
//                            // places
//                        }.flatMap { place ->  Observable.fromArray(flightPrices.Places)
//                            .flatMapIterable { it -> it }
//                            .filter { originStation ->  place.Id == originStation.Id }
//                            .map { destinationStation ->
//                                flightInfo?.arrivalPlace = destinationStation.Name
//                                return@map destinationStation
//                            }
//                        }
//                        // carrier
//                        .flatMap { _place ->  Observable.fromArray(flightPrices.Carriers)
//                            .flatMapIterable { it -> it }
//                            .filter { carrier -> segment.Carrier == carrier.Id }
//                            .map { carrier ->
//                                flightInfo?.carrier = carrier.Name
//                                flightInfo?.let { flightsInfo.add(it) }
//                                return@map carrier
//                            }
//                        }


                },
                onError = { error ->
                    onFlightPricestFetchError(error)
                },
                onComplete = {
                    print("completed")
                })

    }

    override fun setView(flighPricesView: IFlightPricesView) {
        this.flighPricesView = flighPricesView
    }

    override fun destroy() {
        flighPricesView = null
        compositeDisposable?.clear()
    }

    private fun onFlightPricesResult(flightPrices: FlightPricesResults) {
        if (isViewAttached() && flightPrices != null) {
            // logic in kotlin way do async from cba
            //flighPricesView?.showFlightPrices()
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

package com.reza.skyscannertest.ui.flightPrices.presenter.biz

import com.reza.skyscannertest.data.flightPrices.local.FlightInfo
import com.reza.skyscannertest.data.flightPrices.remote.FlightPricesResults
import com.reza.skyscannertest.utils.extensions.Diff
import com.reza.skyscannertest.utils.extensions.UTCDateTime
import com.reza.skyscannertest.utils.extensions.UTCTime
import javax.inject.Inject

class FlightInfoBiz @Inject constructor() {

    fun getFlightPrices(flightPricesResults: FlightPricesResults): MutableList<FlightInfo> {


        val flightsInfo: MutableList<FlightInfo> = arrayListOf()

        flightPricesResults.itineraries?.forEachIndexed { index, itinerary ->


            flightPricesResults.legs?.forEachIndexed { legIndex, leg ->
                //inbound
                if (itinerary.inboundLegId == leg.id) {
                    var flightInfoInbound = FlightInfo()
                    flightPricesResults.carriers?.forEachIndexed { carrierIndex, carrier ->
                        if (leg.carriers?.first() == carrier.id) {
                            flightInfoInbound?.carrier = carrier.name
                            flightInfoInbound?.directionality = leg.directionality
                            flightInfoInbound?.arrivalTime = leg.arrival?.UTCTime()
                            flightInfoInbound?.departureTime = leg.departure?.UTCTime()
                            flightInfoInbound?.duration =
                                leg.departure?.UTCDateTime()?.Diff(leg.arrival?.UTCDateTime()).toString() + "hr(s)"
                            flightInfoInbound?.stops =
                                if (leg.stops?.size != 0) leg.stops?.size.toString() + " stops" else "Direct"
                        }

                    }
                    flightPricesResults.places?.forEachIndexed { palaceIndex, place ->
                        if (leg.originStation == place.id) {
                            flightInfoInbound?.departurePlace = place.code
                        }
                        if (leg.destinationStation == place.id) {
                            flightInfoInbound?.arrivalPlace = place.code
                        }
                    }

                    flightsInfo.add(flightInfoInbound)
                }
                //outbound
                if (itinerary.outboundLegId == leg.id) {
                    var flightInfoOutbound = FlightInfo()
                    flightPricesResults.carriers?.forEachIndexed { carrierIndex, carrier ->
                        if (leg.carriers?.first() == carrier.id) {
                            flightInfoOutbound?.carrier = carrier.name
                            flightInfoOutbound?.directionality = leg.directionality
                            flightInfoOutbound?.arrivalTime = leg.arrival?.UTCTime()
                            flightInfoOutbound?.departureTime = leg.departure?.UTCTime()
                            flightInfoOutbound?.duration =
                                leg.departure?.UTCDateTime()?.Diff(leg.arrival?.UTCDateTime()).toString() + "hr(s)"
                            flightInfoOutbound?.stops =
                                if (leg.stops?.size != 0) leg.stops?.size.toString() + " stops" else "Direct"
                        }

                    }
                    flightPricesResults.places?.forEachIndexed { palaceIndex, place ->
                        if (leg.originStation == place.id) {
                            flightInfoOutbound?.arrivalPlace = place.code
                        }
                        if (leg.destinationStation == place.id) {
                            flightInfoOutbound?.departurePlace = place.code
                        }
                    }
                    flightsInfo.add(flightInfoOutbound)
                }
            }
        }

        return flightsInfo
    }
}
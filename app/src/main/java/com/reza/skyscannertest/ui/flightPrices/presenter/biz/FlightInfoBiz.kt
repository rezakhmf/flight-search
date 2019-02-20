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

        flightPricesResults.Itineraries?.forEachIndexed { index, itinerary ->


            flightPricesResults.Legs?.forEachIndexed { legIndex, leg ->
                //inbound
                if (itinerary.InboundLegId == leg.Id) {
                    var flightInfoInbound = FlightInfo()
                    flightPricesResults.Carriers?.forEachIndexed { carrierIndex, carrier ->
                        if (leg.Carriers?.first() == carrier.Id) {
                            flightInfoInbound?.carrier = carrier.Name
                            flightInfoInbound?.directionality = leg.Directionality
                            flightInfoInbound?.arrivalTime = leg.Arrival?.UTCTime()
                            flightInfoInbound?.departureTime = leg.Departure?.UTCTime()
                            flightInfoInbound?.duration =
                                leg.Departure?.UTCDateTime()?.Diff(leg.Departure?.UTCDateTime()).toString()
                            flightInfoInbound?.stops =
                                if (leg.Stops?.size != 0) leg.Stops?.size.toString() + " Stops" else "Direct"
                        }

                    }
                    flightPricesResults.Places?.forEachIndexed { palaceIndex, place ->
                        if (leg.OriginStation == place.Id) {
                            flightInfoInbound?.departurePlace = place.Code
                        }
                    }

                    flightsInfo.add(flightInfoInbound)
                }
                //outbound
                if (itinerary.OutboundLegId == leg.Id) {
                    var flightInfoOutbound = FlightInfo()
                    flightPricesResults.Carriers?.forEachIndexed { carrierIndex, carrier ->
                        if (leg.Carriers?.first() == carrier.Id) {
                            flightInfoOutbound?.carrier = carrier.Name
                            flightInfoOutbound?.directionality = leg.Directionality
                            flightInfoOutbound?.arrivalTime = leg.Arrival?.UTCTime()
                            flightInfoOutbound?.departureTime = leg.Departure?.UTCTime()
                            flightInfoOutbound?.stops =
                                if (leg.Stops?.size != 0) leg.Stops?.size.toString() + " Stops" else "Direct"
                        }

                    }
                    flightPricesResults.Places?.forEachIndexed { palaceIndex, place ->
                        if (leg.DestinationStation == place.Id) {
                            flightInfoOutbound?.arrivalPlace = place.Code
                        }
                    }
                    flightsInfo.add(flightInfoOutbound)
                }
            }
        }

        return flightsInfo
    }
}
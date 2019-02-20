package com.reza.skyscannertest.ui.flightPrices.presenter.biz

import com.reza.skyscannertest.data.flightPrices.local.FlightInfo
import com.reza.skyscannertest.data.flightPrices.remote.*
import com.reza.skyscannertest.utils.extensions.Diff
import com.reza.skyscannertest.utils.extensions.UTCDateTime
import com.reza.skyscannertest.utils.extensions.UTCTime
import javax.inject.Inject

class FlightInfoBiz @Inject constructor() {

    fun getFlightPrices(flightPricesResults: FlightPricesResults): MutableList<FlightInfo> {


        val flightsInfo: MutableList<FlightInfo> = arrayListOf()
        var flightPairFlag: Boolean = false

        flightPricesResults.itineraries?.forEachIndexed { index, itinerary ->


            flightPricesResults.legs?.forEachIndexed { legIndex, leg ->
                //inbound
                if ( !flightPairFlag && itinerary.inboundLegId == leg.id) {
                    val flightInfo = this.populateFlight(leg,flightPricesResults.carriers, flightPricesResults.places)
                    flightsInfo.add(flightInfo)
                    flightPairFlag = true
                }
                //outbound
                if (flightPairFlag && itinerary.outboundLegId == leg.id) {
                    val flightInfo = this.populateFlight(leg,flightPricesResults.carriers, flightPricesResults.places)
                    flightsInfo.add(flightInfo)
                    flightPairFlag = false
                }
            }
        }

        return flightsInfo
    }


    private fun populateFlight(leg: Leg, carriers: List<Carrier>?, places: List<Place>?) : FlightInfo {

        var flightInfo = FlightInfo()

        carriers?.forEachIndexed { carrierIndex, carrier ->
            if (leg.carriers?.first() == carrier.id) {
                flightInfo?.carrier = "via " + carrier.name
                flightInfo?.directionality = leg.directionality
                flightInfo?.arrivalTime = leg.arrival?.UTCTime()
                flightInfo?.departureTime = leg.departure?.UTCTime()
                flightInfo?.duration =
                    leg.departure?.UTCDateTime()?.Diff(leg.arrival?.UTCDateTime()).toString() + "hr(s)"
                flightInfo?.stops =
                    if (leg.stops?.size != 0) leg.stops?.size.toString() + " stops" else "Direct"
            }

        }
        places?.forEachIndexed { palaceIndex, place ->
            if (leg.originStation == place.id) {
                flightInfo?.departurePlace = place.code
            }
            if (leg.destinationStation == place.id) {
                flightInfo?.arrivalPlace = place.code
            }
        }

        return flightInfo
    }
}
package domine.datasource.airportbook

import domine.model.AirportBooking

interface AirportBookingDataSource {
    fun getAirBookingPairs(): List<Pair<AirportBooking, AirportBooking>>
}
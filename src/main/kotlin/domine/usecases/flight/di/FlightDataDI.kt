package domine.usecases.flight.di

import data.aircraft.AirCraftLocalSource
import data.airport.AirportLocalSource
import data.airportbook.AirportBookingLocalSource
import data.flight.FlightLocalSource
import domine.datasource.flight.FlightDataSource

class FlightDataDI {
    fun providesFlightsData(): FlightDataSource {
        val airportDatasource = AirportLocalSource()
        val airportBookingLocalSource = AirportBookingLocalSource(airportDatasource)
        val airCraftLocalSource = AirCraftLocalSource()

        return FlightLocalSource(
            airCraftLocalSource,
            airportBookingLocalSource
        )
    }
}
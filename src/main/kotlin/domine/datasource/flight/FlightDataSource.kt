package domine.datasource.flight

import domine.model.Flight

interface FlightDataSource {
    fun getFlights(): Map<Int, Flight>
}
package domine.datasource.airport

import domine.model.Airport

interface AirportDatasource {
    fun getAirports(): List<Airport>
}
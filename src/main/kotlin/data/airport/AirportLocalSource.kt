package data.airport

import domine.datasource.airport.AirportDatasource
import domine.model.Airport

class AirportLocalSource: AirportDatasource {
    override fun getAirports(): List<Airport> = listOf(
        Airport("QMX","Mexico City"),
        Airport("CHI","Chicago"),
        Airport("BOG","Bogotá"),
        Airport("CUN","Cancún"),
    )
}
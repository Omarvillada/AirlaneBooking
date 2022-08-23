package data

import domine.datasource.airport.AirportDatasource
import domine.model.AirCraft
import domine.model.Airport

class AirCraftLocalSource : AirportDatasource{
    override fun getAirports(): List<Airport> = listOf(
        AirCraft("Airbus", "A320", getSeatSections()),
        AirCraft("Airbus", "A320", getSeatSections()),
        AirCraft("Airbus", "A320", getSeatSections())
    )
}
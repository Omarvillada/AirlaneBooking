package domine.usecases.flight

import domine.datasource.flight.FlightDataSource
import domine.model.Airport
import domine.model.AirportBooking
import domine.model.Flight
import java.time.LocalDateTime
import java.time.Month

/**
 * 1. Mostrar los vuelos disponibles de un mes
 */
class GetFlights(
    private val flightDataSource: FlightDataSource
) {
    fun invoke(month: Month): Map<Int, Flight> {

        return flightDataSource
            .getFlights()
            .filter {
            flightEntry ->  flightEntry.value.departureArrivalBooking.first.dateTime.month == month
        }
    }

    private fun getAirportPair(): Pair<AirportBooking, AirportBooking> {
        return Pair(
            AirportBooking(
                airport = Airport("BOG", "Bogotá"),
                dateTime = LocalDateTime.of(
                    2023, Month.JANUARY, 10, 13, 0, 0
                )
            ),
            AirportBooking(
                airport = Airport("CUN", "Cancún"),
                dateTime = LocalDateTime.of(
                    2023, Month.JANUARY, 10, 17, 30, 0
                )
            )
        )
    }
}
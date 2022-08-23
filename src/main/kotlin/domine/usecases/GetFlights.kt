package domine.usecases

import domine.model.AirCraft
import domine.model.Airport
import domine.model.AirportBooking
import domine.model.Flight
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.Month
import domine.presentation.Formatter

class GetFlights(
    private val formatter: Formatter<Flight>
) {
    fun invoke(): String {
        val flight = Flight(
            number = "Y4 708",
            airCraft = AirCraft("Airbus","A320"),
            price = BigDecimal(100.0),
            departureArrivalBooking = getAirportPair()
        )
        val flights = listOf(
            flight,
            flight,
            flight
        )
        return formatter.format(flights)
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
package domine.model

import domine.model.baggage.pack.BaggagePackage
import domine.model.seat.Seat
import domine.presentation.Formatter
import java.math.BigDecimal


data class Ticket(
    val flight: Flight,
    val passenger: Passenger,
    val baggage: BaggagePackage,
    val seat: Seat,
    val totalPrice: BigDecimal = flight.price + baggage.price + seat.price
): Formatter {
    override fun format(): String {
        return """
            Passenger: ${passenger.name}
            Flight Number: ${flight.number}
            Departure: ${flight.departureArrivalBooking.first.airport.name}
            Arrival: ${flight.departureArrivalBooking.second.airport.name}
            Flight Price $${flight.price}
            BaggagePlan: $//{baggage.format()}
            Seat: ${seat.number}
            Total: $$totalPrice
        """.trimIndent()
    }

}

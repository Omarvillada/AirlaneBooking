package domine.model

import domine.model.baggage.pack.BaggagePackage
import domine.model.seat.Seat
import java.math.BigDecimal


data class Ticket(
    val flight: Flight,
    val passenger: Passenger,
    val baggage: BaggagePackage,
    val seat: Seat,
    val totalPrice: BigDecimal = flight.price + baggage.price + seat.price
)


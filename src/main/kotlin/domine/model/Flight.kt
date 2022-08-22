package domine.model

import domine.presentation.Formatter
import java.math.BigDecimal
import java.time.Duration
import java.time.format.DateTimeFormatter

data class Flight(
    val number: String,
    val airCraft: AirCraft,
    val price: BigDecimal,
    val departureArrivalBooking: Pair<AirportBooking, AirportBooking>,
    val duration: Duration = Duration.between(
        departureArrivalBooking.second.dateTime,
        departureArrivalBooking.first.dateTime
    )
)

import domine.model.*
import domine.model.baggage.pack.regular.RegularBasic
import domine.model.seat.Seat
import domine.model.seat.SeatClass
import domine.model.seat.SeatStatus
import domine.usecases.GetFlights
import presentation.flight.FlightConsoleFormat
import presentation.flight.FlightHTMLFormat
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.Month

fun main() {
    val getFlights = GetFlights(FlightConsoleFormat())
    val flightFormat = getFlights.invoke()
    println(flightFormat)
}

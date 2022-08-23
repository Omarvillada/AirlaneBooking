import domine.model.*
import domine.model.baggage.pack.regular.RegularBasic
import domine.model.seat.Seat
import domine.model.seat.SeatClass
import domine.model.seat.SeatStatus
import domine.presentation.Formatter
import domine.usecases.GetFlights
import presentation.PresentationFormat
import presentation.flight.FlightConsoleFormat
import presentation.flight.FlightHTMLFormat
import presentation.flight.FlightPresentationFactory


fun main() {

    val format = PresentationFormat.HTML
    val flightFormat: Formatter<Flight> = FlightPresentationFactory().getPresentationFormat(format)

    val flights = GetFlights(flightFormat).invoke()
    //val flightFormat = getFlights.invoke()
    println(flights)
}

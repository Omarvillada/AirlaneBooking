import domine.model.*
import domine.presentation.Formatter
import domine.usecases.flight.GetFlights
import presentation.PresentationFormat
import presentation.flight.FlightPresentationFactory


fun main() {

    val format = PresentationFormat.HTML
    val flightFormat: Formatter<Flight> = FlightPresentationFactory().getPresentationFormat(format)
    val flights = GetFlights(flightFormat).invoke()
    println(flights)
}

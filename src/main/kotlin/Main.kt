import data.aircraft.AirCraftLocalSource
import data.airport.AirportLocalSource
import data.airportbook.AirportBookingLocalSource
import data.flight.FlightLocalSource
import domine.model.*
import domine.presentation.Formatter
import domine.usecases.flight.GetFlights
import presentation.PresentationFormat
import presentation.flight.FlightPresentationFactory
import java.time.Month


fun main() {

    val format = PresentationFormat.HTML
    val flightFormat: Formatter<Flight> = FlightPresentationFactory().getPresentationFormat(format)

    val airportLocalSource = AirportLocalSource()
    val airportBookingLocalSource = AirportBookingLocalSource(
        airportLocalSource
    )
    val airCraftLocal = AirCraftLocalSource()
    val flightLocal = FlightLocalSource(
        airCraftLocal, airportBookingLocalSource
    )
    val flights = GetFlights(flightLocal).invoke(Month.JANUARY)
    println(flights)
}

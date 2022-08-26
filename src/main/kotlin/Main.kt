import data.aircraft.AirCraftLocalSource
import data.airport.AirportLocalSource
import data.airportbook.AirportBookingLocalSource
import data.baggage.BaggageRegularLocalSource
import data.baggage.BaggageVClubLocalSource
import data.flight.FlightLocalSource
import data.ticket.TicketListSingleton
import domine.datasource.airport.AirportDatasource
import domine.model.Flight
import domine.usecases.baggage.GetBaggagePackage
import domine.usecases.flight.GetFlightSaved
import domine.usecases.flight.GetFlights
import domine.usecases.flight.di.FlightDataDI
import domine.usecases.ticket.AssignFlightToTicket
import domine.usecases.ticket.di.TicketDataDI
import presentation.PresentationFormat
import presentation.baggage.BaggagePackageConsole
import presentation.baggage.types.BaggageTypesConsole
import presentation.extfunction.isMenuOptionValid
import presentation.flight.FlightPresentationFactory
import presentation.flight.formats.FlightConsoleFormat
import presentation.menu.UIMenu
import presentation.utils.Formatter
import java.time.Month



fun main() {
    val format = PresentationFormat.CONSOLE
    val flightsPresentation = FlightPresentationFactory().getPresentationFormat(format)
    val ticketData = TicketDataDI().providesTicketsData()
    val flightData = FlightDataDI().providesFlightsData()
    /** 1. Mostrar lista de Vuelos **/
    val uiMenuFlight = object : UIMenu<Flight> {}
    val flightsMap = GetFlights(flightData).invoke(Month.JANUARY)
    val flightSelected = uiMenuFlight.showMenu(flightsMap, flightsPresentation)



    /** 2. Asignar un vuelo al ticket **/
    AssignFlightToTicket(ticketData).invoke(flightSelected)

    val flightSaved = GetFlightSaved(ticketData).invoke()
    println(
        FlightConsoleFormat().format(flightSaved)
    )
}

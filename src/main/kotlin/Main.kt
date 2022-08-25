import data.aircraft.AirCraftLocalSource
import data.airport.AirportLocalSource
import data.airportbook.AirportBookingLocalSource
import data.baggage.BaggageRegularLocalSource
import data.baggage.BaggageVClubLocalSource
import data.flight.FlightLocalSource
import data.ticket.TicketListSingleton
import domine.datasource.airport.AirportDatasource
import domine.usecases.baggage.GetBaggagePackage
import domine.usecases.flight.GetFlightSaved
import domine.usecases.flight.GetFlights
import domine.usecases.flight.di.FlightDataDI
import domine.usecases.ticket.AssignFlightToTicket
import domine.usecases.ticket.di.TicketDataDI
import presentation.baggage.BaggagePackageConsole
import presentation.baggage.types.BaggageTypesConsole
import presentation.extfunction.isMenuOptionValid
import presentation.flight.formats.FlightConsoleFormat
import java.time.Month



fun main() {

    val ticketData = TicketDataDI().providesTicketsData()

    val getFlights = GetFlights(
        FlightDataDI().providesFlightsData()
    ).invoke(Month.JANUARY)


    var flightOption: String = ""
    do {
        //Mostrar la lista de flights
        getFlights.forEach { t, u ->
            print("$t. ")
            println(FlightConsoleFormat().format(u))
        }
        println("*** Select Number Option ***")
        flightOption = readLine().orEmpty()


    }while (!flightOption.isMenuOptionValid(flightsMap = getFlights))

    println("Option Selected: $flightOption")

    println("*** Flight Selected ***")

    val flight = getFlights[flightOption.toInt()]
    //Asignar un vuelo al ticket
    AssignFlightToTicket(ticketData).invoke(flight)

    val flightSelected = GetFlightSaved(ticketData).invoke()
    println(
        FlightConsoleFormat().format(flightSelected)
    )
}

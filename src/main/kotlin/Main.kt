import data.aircraft.AirCraftLocalSource
import data.airport.AirportLocalSource
import data.airportbook.AirportBookingLocalSource
import data.baggage.BaggageRegularLocalSource
import data.baggage.BaggageVClubLocalSource
import data.flight.FlightLocalSource
import data.ticket.TicketListSingleton
import domine.datasource.airport.AirportDatasource
import domine.usecases.baggage.GetBaggagePackage
import domine.usecases.flight.GetFlights
import domine.usecases.ticket.AssignFlightToTicket
import presentation.baggage.BaggagePackageConsole
import presentation.baggage.types.BaggageTypesConsole
import presentation.flight.formats.FlightConsoleFormat
import java.time.Month

fun main() {

    val airportDatasource = AirportLocalSource()
    val airportBookingLocalSource = AirportBookingLocalSource(airportDatasource)
    val airCraftLocalSource = AirCraftLocalSource()

    val flightLocal = FlightLocalSource(airCraftLocalSource,airportBookingLocalSource)
    val getFlights = GetFlights(flightLocal).invoke(Month.JANUARY)
    getFlights.forEach { t, u ->
        print("$t. ")
        println(FlightConsoleFormat().format(u))
    }

    println("*** Flight Selected ***")
    val ticketListSingleton = TicketListSingleton()
    val flight = getFlights[1]
    //Asignar un vuelo al ticket
    AssignFlightToTicket(ticketListSingleton).invoke(flight)

    val flightSelected = ticketListSingleton.tickets.first().flight
    println(
        FlightConsoleFormat().format(flightSelected)
    )




/*
    val vClubLocalSource = BaggageVClubLocalSource()
    val getVClubPackages = GetBaggagePackage(vClubLocalSource).invoke()

    println("*** VClub Baggage´s ***")
    getVClubPackages.forEach {(t, u) ->
        print("$t. ")

        println(
            BaggagePackageConsole(
                BaggageTypesConsole()
            ).format(u))
    }

    val regularLocalSource = BaggageRegularLocalSource()
    val getRegularPackages = GetBaggagePackage(regularLocalSource).invoke()
    println()
    println("*** Regular Baggage´s ***")
    getRegularPackages.forEach {(t, u) ->
        print("$t. ")
        println(
            BaggagePackageConsole(
                BaggageTypesConsole()
            ).format(u))
    }

 */
}

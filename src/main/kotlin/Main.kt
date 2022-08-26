import data.baggage.BaggageRegularLocalSource
import data.baggage.BaggageVClubLocalSource
import domine.model.Flight
import domine.model.baggage.pack.BaggagePackage
import domine.model.seat.Seat
import domine.model.seat.SeatSection
import domine.usecases.baggage.GetBaggagePackage
import domine.usecases.baggage.GetBaggageSaved
import domine.usecases.flight.GetFlightSaved
import domine.usecases.flight.GetFlights
import domine.usecases.flight.di.FlightDataDI
import domine.usecases.seat.GetSeatSaved
import domine.usecases.seat.GetSeatsBy
import domine.usecases.seat.GetSeatsSection
import domine.usecases.ticket.AssignBaggagePackageToTicket
import domine.usecases.ticket.AssignFlightToTicket
import domine.usecases.ticket.AssignSeatToTicked
import domine.usecases.ticket.di.TicketDataDI
import presentation.PresentationFormat
import presentation.baggage.BaggagePackPresentationFactory
import presentation.baggage.BaggagePackageEnum
import presentation.flight.FlightPresentationFactory
import presentation.flight.formats.FlightConsoleFormat
import presentation.menu.UIMenu
import presentation.seat.SeatPresentationFactory
import presentation.seat.section.SeatSectionPresentationFactory
import presentation.utils.Formatter
import java.time.Month



fun main() {
    val format = PresentationFormat.CONSOLE
    val flightsPresentation = FlightPresentationFactory().getPresentationFormat(format)
    val baggagePackPresentation = BaggagePackPresentationFactory().getPresentationFormat(format)
    val seatSectionPresentation = SeatSectionPresentationFactory().getPresentationFormat(format)
    val seatPresentation = SeatPresentationFactory().getPresentationFormat(format)
    val ticketData = TicketDataDI().providesTicketsData()
    val flightData = FlightDataDI().providesFlightsData()
    /** 1. Mostrar lista de Vuelos **/
    val uiMenuFlight = object : UIMenu<Flight> {}
    val flightsMap = GetFlights(flightData).invoke(Month.JANUARY)
    val flightSelected = uiMenuFlight.showMenu(flightsMap, flightsPresentation)



    /** 2. Asignar un vuelo al ticket **/
    AssignFlightToTicket(ticketData).invoke(flightSelected)
    val getFlightSaved = GetFlightSaved(ticketData)
    val flightSaved = getFlightSaved()
    println(
        FlightConsoleFormat().format(flightSaved)
    )

    /**
     * 3. Showing Baggage Packages
     */
    //Regular
    //VClub
    val baggagePackOption = mapOf(
        1 to BaggagePackageEnum.Regular,
        2 to BaggagePackageEnum.VClub
    )
    val uiMenuBaggagePackOpt = object : UIMenu<BaggagePackageEnum>{ }
    val baggagePackageOption = uiMenuBaggagePackOpt.showMenu(
        baggagePackOption, object : Formatter<BaggagePackageEnum>{
            override fun format(t: BaggagePackageEnum): String = t.name

        }
    )

    val baggagePackData = when (baggagePackageOption) {
        BaggagePackageEnum.Regular -> BaggageRegularLocalSource()
        BaggagePackageEnum.VClub -> BaggageVClubLocalSource()
        else -> BaggageRegularLocalSource()
    }

    val baggagePackMap = GetBaggagePackage(baggagePackData).invoke()
    val uiMenuBaggagePack = object : UIMenu<BaggagePackage> { }
    val baggagePackageSelected = uiMenuBaggagePack.showMenu(
        baggagePackMap, baggagePackPresentation
    )



    /**
     * 4. Saving Baggage in Ticket
     */

    if (baggagePackageSelected != null) {
        AssignBaggagePackageToTicket(ticketData).invoke(baggagePackageSelected)
    }
    val baggagePackSaved = GetBaggageSaved(ticketData).invoke()
    println("Baggage Package Saved")
    println(
        baggagePackPresentation.format(baggagePackSaved)
    )

    /** 5. Showing available seats */
    val seatSectionMap = GetSeatsSection(getFlightSaved).invoke()
    val uiSeatsSectionsMenu = object : UIMenu<SeatSection> { }
    val seatSectionSelected = uiSeatsSectionsMenu.showMenu(
        seatSectionMap, seatSectionPresentation
    )

    val getSeatsBy = GetSeatsBy()
    val seatsMap = getSeatsBy(seatSectionSelected)
    val uiSeatsMenu = object : UIMenu<Seat> { }
    val seatSelected = uiSeatsMenu.showMenu(
        seatsMap, seatPresentation
    )


    /** 6. Save Seat Selected */
    AssignSeatToTicked(ticketData).invoke(seatSelected)
    val seatSaved = GetSeatSaved(ticketData).invoke()

    println("Seat Saved")
    println(
        seatPresentation.format(seatSaved)
    )

}

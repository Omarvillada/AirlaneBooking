package presentation.reservation

import domine.model.Reservation
import presentation.PresentationFactory
import presentation.PresentationFormat
import presentation.baggage.format.BaggagePackageConsoleFormat
import presentation.baggage.types.format.BaggageTypesConsoleFormat
import presentation.reservation.format.ReservationConsoleFormat
import presentation.ticket.formats.TicketConsoleFormat
import presentation.utils.Formatter

class ReservationPresentationFactory: PresentationFactory<Reservation> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<Reservation> {

    }

}
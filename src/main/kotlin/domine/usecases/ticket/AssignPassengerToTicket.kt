package domine.usecases.ticket

import domine.datasource.ticket.TicketDataSource
import domine.model.Passenger
import domine.model.Ticket

/**
 * 7. Introducir información del pasajero
 */
class AssignPassengersToTicket(
    private val ticketDataSource: TicketDataSource
) {
    operator fun invoke(passengers: List<Passenger>): List<Ticket>{
        val firstTicket =  ticketDataSource.tickets.first().apply {
            this.passenger = passengers.first()
        }

        val tickets = passengers.drop(1).map {
            val ticket = Ticket().apply {
                this.passenger = it
                this.baggagePackage = firstTicket.baggagePackage
                this.seat = firstTicket.seat
                this.totalPrice = firstTicket.totalPrice
            }
            ticket
        }
        ticketDataSource.tickets += tickets
        return ticketDataSource.tickets
    }
}
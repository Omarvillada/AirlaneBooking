package domine.usecases.ticket

import domine.datasource.ticket.TicketDataSource
import domine.model.Passenger
import domine.model.Ticket

/**
 * 7. Introducir información del pasajero
 */
class AssignPassengerToTicket(
    private val ticketDataSource: TicketDataSource
) {
    operator fun invoke(passenger: Passenger):Ticket{
        return ticketDataSource.tickets.first().apply {
            this.passenger = passenger
        }
    }
}
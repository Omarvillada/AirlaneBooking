package domine.usecases.ticket

import domine.datasource.ticket.TicketDataSource
import domine.model.Flight
import domine.model.Ticket

/**
 * 2. Seleccionar un vuelo disponible
 */
class AssignFlightToTicket(
    private val ticketDataSource: TicketDataSource
) {
    operator fun invoke(flight: Flight?): Ticket? {
        return flight?.let {
            ticketDataSource.tickets.first().apply {
                this.flight = flight
            }
        }
    }
}
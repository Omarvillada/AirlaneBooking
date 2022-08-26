package domine.usecases.ticket

import domine.datasource.ticket.TicketDataSource
import domine.model.Ticket
import domine.model.seat.Seat

/**
 * Seleccionar un asiento
 */
class AssignSeatToTicked(
    private val ticketDataSource: TicketDataSource
) {
    operator fun invoke(seat: Seat?):Ticket?{
        return seat?.let {
            ticketDataSource.tickets.first().apply {
                this.seat = it
            }
        }
    }
}
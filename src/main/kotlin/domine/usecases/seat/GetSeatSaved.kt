package domine.usecases.seat

import domine.datasource.ticket.TicketDataSource
import domine.model.seat.Seat

class GetSeatSaved(
    private val ticketData: TicketDataSource
) {
    operator fun invoke(): Seat {
        return ticketData.tickets.first().seat
    }
}

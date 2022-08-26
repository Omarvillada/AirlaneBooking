package domine.usecases.ticket

import domine.datasource.ticket.TicketDataSource
import domine.model.Ticket

class GetTickets(
    private val ticketDataSource: TicketDataSource
) {
     operator fun invoke(): List<Ticket> {
         return ticketDataSource.tickets
     }
}
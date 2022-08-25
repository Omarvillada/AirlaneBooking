package domine.usecases.flight

import domine.datasource.ticket.TicketDataSource
import domine.model.Flight

class GetFlightSaved(
    private val ticketDataSource: TicketDataSource
)  {
    operator  fun invoke(): Flight {
        return ticketDataSource.tickets.first().flight
    }
}
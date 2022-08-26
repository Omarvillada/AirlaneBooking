package data.ticket

import domine.datasource.ticket.TicketDataSource
import domine.model.Ticket

class TicketListSingleton : TicketDataSource {

    companion object {
        private val tickets = mutableListOf(
            Ticket()
        )
    }

    override val tickets: MutableList<Ticket> = TicketListSingleton.tickets
}
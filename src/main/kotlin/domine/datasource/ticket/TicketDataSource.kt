package domine.datasource.ticket

import domine.model.Ticket

interface TicketDataSource {

    val tickets: List<Ticket>
}
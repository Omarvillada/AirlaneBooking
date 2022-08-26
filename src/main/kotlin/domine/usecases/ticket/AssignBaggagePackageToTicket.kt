package domine.usecases.ticket

import domine.datasource.ticket.TicketDataSource
import domine.model.Ticket
import domine.model.baggage.pack.BaggagePackage

/**
 * 4. Seleccionar un equipaje
 */
class AssignBaggagePackageToTicket(
     private val ticketDataSource: TicketDataSource
) {
     operator fun invoke(baggagePackage: BaggagePackage) : Ticket?{
          return baggagePackage?.let {
               ticketDataSource.tickets.first().apply {
                    this.baggagePackage = it
               }
          }
     }
}
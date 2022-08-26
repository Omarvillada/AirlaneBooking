package domine.usecases.baggage

import domine.datasource.ticket.TicketDataSource
import domine.model.baggage.pack.BaggagePackage

class GetBaggageSaved(
    private val ticketDataSource: TicketDataSource
) {
    operator fun invoke(): BaggagePackage {
        return ticketDataSource.tickets.first().baggagePackage
    }
}
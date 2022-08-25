package domine.usecases.ticket.di

import data.ticket.TicketListSingleton
import domine.datasource.ticket.TicketDataSource

class TicketDataDI {
    fun providesTicketsData(): TicketDataSource {
        return TicketListSingleton()
    }
}
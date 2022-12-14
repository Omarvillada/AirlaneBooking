package domine.usecases.reservation

import domine.datasource.ReservationDataSource
import domine.model.Reservation
import domine.model.Ticket
import domine.usecases.ticket.GetTickets

private const val CODE_SIZE = 5
class AssignTicketToReservation(
    private val reservationDataSource: ReservationDataSource,
    private val getTickets: GetTickets
) {
    operator fun invoke(): Reservation{
        return reservationDataSource.reservation.apply {
            this.code = generateCode()
            this.departureTickets = getTickets()
            this.returnTickets = getTickets()
        }
    }

    private fun generateCode(): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..CODE_SIZE)
            .map {
            allowedChars.random()
        }.joinToString("")
    }
}
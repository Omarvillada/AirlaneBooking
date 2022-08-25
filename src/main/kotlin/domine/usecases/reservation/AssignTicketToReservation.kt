package domine.usecases.reservation

import domine.datasource.ReservationDataSource
import domine.model.Reservation
import domine.model.Ticket

private const val CODE_SIZE = 5
class AssignTicketToReservation(
    private val reservationDataSource: ReservationDataSource
) {
    operator fun invoke(tickets: List<Ticket>): Reservation{
        return reservationDataSource.reservation.apply {
            this.code = generateCode()
            this.departureTickets = tickets
            this.returnTickets = tickets
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
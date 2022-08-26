package domine.usecases.seat

import domine.model.seat.Seat
import domine.model.seat.SeatSection
import domine.model.seat.SeatStatus

class GetSeatsBy {

    operator fun invoke(seatSection: SeatSection?): Map<Int, Seat> {
        return seatSection?.seats
            ?.filter {
                it.status == SeatStatus.AVAILABLE
            }
            ?.mapIndexed { index, seat ->
                index + 1 to seat
            }?.toMap() ?: mapOf()
    }
}
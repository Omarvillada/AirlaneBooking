package domine.usecases.reservation

import domine.datasource.ReservationDataSource
import domine.model.Reservation

/**
 * GetReservation
 */
class GetReservation(
    private val reservationDataSource: ReservationDataSource
) {
    operator fun invoke() : Reservation  {
        return reservationDataSource.reservation
    }
}
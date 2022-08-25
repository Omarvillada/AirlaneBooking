package data.reservation

import domine.datasource.ReservationDataSource
import domine.model.Reservation

class ReservationSingleton: ReservationDataSource {

    companion object {
        private val reservation = Reservation()
    }

    override val reservation: Reservation = ReservationSingleton.reservation
}
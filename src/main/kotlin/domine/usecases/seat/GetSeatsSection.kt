package domine.usecases.seat

import domine.model.seat.SeatSection
import domine.usecases.flight.GetFlightSaved

/**
 * 5. Mostrar los asientos disponibles
 */
class GetSeatsSection(
    private val getFlightSaved: GetFlightSaved
) {
    operator fun invoke(): Map<Int, SeatSection> {
        //flight selected
        val flight = getFlightSaved()
        return flight
            .airCraft
            .seatSections
            .mapIndexed { index, seatSection ->
                index + 1 to seatSection
            }.toMap()


    }
}
package presentation.seat

import domine.model.seat.Seat
import presentation.PresentationFactory
import presentation.PresentationFormat
import presentation.utils.Formatter

class SeatPresentationFactory: PresentationFactory<Seat> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<Seat> {
        TODO("Not yet implemented")
    }
}
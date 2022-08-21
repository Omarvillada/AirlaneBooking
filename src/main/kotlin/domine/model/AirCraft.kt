package domine.model

import domine.model.seat.SeatSection

data class AirCraft(
    val name: String,
    val model: String,
    val airline: Airline = Airline("Vl", "Volarios"),
    //val seatSections: Map<Int,SeatSection>
)

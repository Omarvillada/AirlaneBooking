package domine.model

import domine.model.seat.SeatSection

data class AirCraft(
    val name: String,
    val model: String,
    val seatSections: List<SeatSection>,
    val airline: Airline = Airline("Vl", "Volarios"),

)

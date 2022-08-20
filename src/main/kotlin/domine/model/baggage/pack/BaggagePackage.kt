package domine.model.baggage.pack

import java.math.BigDecimal

data class BaggagePackage(
    open val name: String = "Baggage Plan",
    open val price: BigDecimal =  BigDecimal(0.0),
){
    open val boardingTurn: BoardingTurn = BoardingTurn.FIRST
}

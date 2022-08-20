package domine.model.baggage.pack

import domine.model.baggage.type.BaggageType
import domine.model.baggage.type.BigHand
import domine.model.baggage.type.Checked
import domine.model.baggage.type.Hand
import java.math.BigDecimal

open class BaggagePackage(
    open val name: String = "Baggage Plan",
    open val price: BigDecimal =  BigDecimal(0.0),
){
    open val boardingTurn: BoardingTurn = BoardingTurn.FIRST
    open val baggageType: List<BaggageType> = listOf(
        Hand(),
        BigHand(),
        Checked()
    )
}

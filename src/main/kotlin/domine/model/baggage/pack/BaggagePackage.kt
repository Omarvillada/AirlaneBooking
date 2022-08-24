package domine.model.baggage.pack

import domine.model.baggage.type.BaggageTypes
import domine.model.baggage.type.BigHand
import domine.model.baggage.type.Checked
import domine.model.baggage.type.Hand
import java.math.BigDecimal

abstract class BaggagePackage {
    abstract val name: String
    abstract val price: BigDecimal

    abstract val boardingTurn: BoardingTurn
    open val baggageTypes: List<BaggageTypes> = listOf(
        Hand(),
        BigHand(),
        Checked()
    )
}

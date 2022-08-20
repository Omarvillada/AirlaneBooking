package domine.model.baggage.pack.regular

import domine.model.baggage.pack.BaggagePackage
import domine.model.baggage.pack.BoardingTurn
import domine.model.baggage.type.BaggageType
import java.math.BigDecimal

abstract class Regular(
    override val price: BigDecimal
) : BaggagePackage() {
    abstract override val name: String
    abstract override val boardingTurn: BoardingTurn

}
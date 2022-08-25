package domine.model.baggage.pack.vclub

import domine.model.baggage.pack.BaggagePackage
import domine.model.baggage.pack.BoardingTurn
import domine.model.baggage.type.BaggageType
import domine.model.baggage.type.BoxPacked
import java.math.BigDecimal
//6.Mostrar
const val DISCOUNT = 30
abstract class VClub(
    price: BigDecimal
) : BaggagePackage() {

    override val price: BigDecimal = price
        get() {
            return (field * BigDecimal(DISCOUNT)) / BigDecimal(100)
        }

    abstract override val name: String
    abstract override val boardingTurn: BoardingTurn

    override val baggageTypes: List<BaggageType>
        get() = super.baggageTypes + listOf(
            BoxPacked()
        )
}
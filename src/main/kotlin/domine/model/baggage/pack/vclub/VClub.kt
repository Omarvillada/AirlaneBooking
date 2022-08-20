package domine.model.baggage.pack.vclub

import domine.model.baggage.pack.BaggagePackage
import domine.model.baggage.pack.BoardingTurn
import domine.model.baggage.type.BaggageType
import domine.model.baggage.type.BoxPacked
import java.math.BigDecimal

const val DISCOUNT = 30
abstract class VClub(
    final override var price: BigDecimal
) : BaggagePackage() {
    init {
        price = (price * BigDecimal(DISCOUNT)) / BigDecimal(100)
    }

    abstract override val name: String
    abstract override val boardingTurn: BoardingTurn

    override val baggageType: List<BaggageType>
        get() = super.baggageType + listOf(
            BoxPacked()
        )
}
package domine.model.baggage.pack.vclub

import domine.model.baggage.pack.BaggagePackage
import domine.model.baggage.type.BaggageType
import domine.model.baggage.type.BoxPacked
import java.math.BigDecimal

const val DISCOUNT = 30
open class VClub(
    override val name: String,
    final override var price: BigDecimal
) : BaggagePackage() {

    init {
        price = (price * BigDecimal(DISCOUNT)) / BigDecimal(100)
    }

    override val baggageType: List<BaggageType>
        get() = super.baggageType + listOf(
            BoxPacked()
        )
}
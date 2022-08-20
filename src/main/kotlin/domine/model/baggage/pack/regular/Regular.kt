package domine.model.baggage.pack.regular

import domine.model.baggage.pack.BaggagePackage
import domine.model.baggage.type.BaggageType
import java.math.BigDecimal

open class Regular(
    override val name: String,
    override val price: BigDecimal
) : BaggagePackage() {

}
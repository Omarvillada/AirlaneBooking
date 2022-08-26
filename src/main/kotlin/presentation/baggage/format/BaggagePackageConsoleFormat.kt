package presentation.baggage.format

import domine.model.baggage.pack.BaggagePackage
import domine.model.baggage.type.BaggageType
import presentation.utils.Formatter

class BaggagePackageConsoleFormat(
    private val baggageType: Formatter<BaggageType>
) : Formatter<BaggagePackage> {
    override fun format(t: BaggagePackage): String {
        return """
            ${t.name}
            ${baggageType.format(t.baggageTypes).trim()}
            Boarding Turn: ${t.boardingTurn.name}
            Price ${t.price}
        """.trimIndent()
    }

}
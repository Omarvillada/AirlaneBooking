package presentation.baggage

import domine.model.baggage.pack.BaggagePackage
import domine.model.baggage.type.BaggageTypes
import domine.presentation.Formatter

class BaggagePackageConsole(
    private val baggageType: Formatter<BaggageTypes>
): Formatter<BaggagePackage> {
    override fun format(t: BaggagePackage): String {
        return """
            ${t.name}
            ${baggageType.format(t.baggageTypes).trim()}
        """.trimIndent()
    }
}
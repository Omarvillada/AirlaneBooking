package presentation.baggage.types

import domine.model.baggage.type.BaggageTypes
import domine.presentation.Formatter

class BaggageTypesConsole: Formatter<BaggageTypes> {
    override fun format(t: BaggageTypes): String {
        return """
            ${t.emoji} ${t.quantity} ${t.title}
        """.trimIndent()
    }
}
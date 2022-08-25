package presentation.baggage.types

import domine.model.baggage.type.BaggageType
import presentation.utils.Formatter

class BaggageTypesConsole: Formatter<BaggageType> {
    override fun format(t: BaggageType): String {
        return """
            ${t.emoji} ${t.quantity} ${t.title}
        """.trimIndent()
    }
}
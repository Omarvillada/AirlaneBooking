package presentation.baggage.types.format

import domine.model.baggage.type.BaggageType
import presentation.utils.Formatter

class BaggageTypesConsoleFormat: Formatter<BaggageType> {
    override fun format(t: BaggageType): String {
        return """
            ${t.emoji} ${t.quantity} ${t.title}
        """.trimIndent()
    }
}
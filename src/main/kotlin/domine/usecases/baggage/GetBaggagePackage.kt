package domine.usecases.baggage

import domine.model.baggage.pack.BaggagePackage

/**
 * 3. Mostrar los tipos de equipaje disponibles
 */
class GetBaggagePackage {
    operator fun invoke(): Map<Int, BaggagePackage> {
        return mapOf()
    }
}
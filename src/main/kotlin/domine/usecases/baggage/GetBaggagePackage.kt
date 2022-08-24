package domine.usecases.baggage

import domine.datasource.baggage.BaggagePackageDataSource
import domine.model.baggage.pack.BaggagePackage

/**
 * 3. Mostrar los tipos de equipaje disponibles
 */
class GetBaggagePackage(
    private val baggagePackageDataSource: BaggagePackageDataSource
) {
    operator fun invoke(): Map<Int, BaggagePackage> {
        return baggagePackageDataSource.getBaggagePacks()
    }
}
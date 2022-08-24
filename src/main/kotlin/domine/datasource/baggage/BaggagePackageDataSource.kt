package domine.datasource.baggage

import domine.model.baggage.pack.BaggagePackage

interface BaggagePackageDataSource {
    fun getBaggagePacks(): Map<Int, BaggagePackage>
}
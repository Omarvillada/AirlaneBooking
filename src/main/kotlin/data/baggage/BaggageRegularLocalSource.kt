package data.baggage

import domine.model.baggage.pack.BaggagePackage
import domine.model.baggage.pack.regular.RegularBasic
import domine.model.baggage.pack.regular.RegularClassic
import domine.model.baggage.pack.regular.RegularPlus

class BaggageRegularLocalSource: BaggagePackagesLocalSource() {
    override fun getBaggagePacks(): Map<Int, BaggagePackage> {
        return mapOf(
            1 to RegularBasic(price),
            2 to RegularClassic(price),
            3 to RegularPlus(price)
        )
    }
}
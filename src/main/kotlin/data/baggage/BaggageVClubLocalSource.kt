package data.baggage

import domine.model.baggage.pack.BaggagePackage
import domine.model.baggage.pack.vclub.ClubBasic
import domine.model.baggage.pack.vclub.ClubClassic
import domine.model.baggage.pack.vclub.ClubPlus

class BaggageVClubLocalSource: BaggagePackagesLocalSource() {
    override fun getBaggagePacks(): Map<Int, BaggagePackage> {
        return mapOf(
            1 to ClubBasic(price),
            2 to ClubClassic(price),
            3 to ClubPlus(price)
        )
    }
}
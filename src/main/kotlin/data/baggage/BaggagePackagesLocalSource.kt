package data.baggage

import domine.datasource.baggage.BaggagePackageDataSource
import java.math.BigDecimal

abstract class BaggagePackagesLocalSource: BaggagePackageDataSource {
    val price: BigDecimal = BigDecimal(50)
}
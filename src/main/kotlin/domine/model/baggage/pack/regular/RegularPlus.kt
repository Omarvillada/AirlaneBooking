package domine.model.baggage.pack.regular

import domine.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class RegularPlus( price: BigDecimal) : Regular(price) {
    override val name: String = "Plus"
    override val boardingTurn: BoardingTurn = BoardingTurn.FIRST

    override val price: BigDecimal = price + BigDecimal(20)
}
package domine.model.baggage.pack.regular

import domine.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class RegularClassic(price: BigDecimal) : Regular(price) {
    override val name: String = "RegularClassic"
    override val boardingTurn: BoardingTurn = BoardingTurn.SECOND
    override val price: BigDecimal = price + BigDecimal(10)
}
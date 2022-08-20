package domine.model.baggage.pack.regular

import domine.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class Basic(name: String = "Basic", price: BigDecimal) : Regular(name, price) {
    override val boardingTurn: BoardingTurn = BoardingTurn.END
}
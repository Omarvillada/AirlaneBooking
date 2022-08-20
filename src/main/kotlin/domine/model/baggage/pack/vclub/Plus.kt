package domine.model.baggage.pack.vclub

import domine.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class Plus(
    name: String = "Plus",
    price: BigDecimal) : VClub(name, price) {
    override val boardingTurn: BoardingTurn = BoardingTurn.FIRST
}
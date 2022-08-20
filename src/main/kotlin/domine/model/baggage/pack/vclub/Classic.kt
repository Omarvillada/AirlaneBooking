package domine.model.baggage.pack.vclub

import domine.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class Classic(
    name: String = "Classic VClub",
    price: BigDecimal) : VClub(name, price) {
    override val boardingTurn: BoardingTurn = BoardingTurn.SECOND
}
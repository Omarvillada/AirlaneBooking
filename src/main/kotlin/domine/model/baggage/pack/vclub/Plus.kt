package domine.model.baggage.pack.vclub

import domine.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class Plus(
    price: BigDecimal
) : VClub(price) {
    override val name: String = "ClubPlus"
    override val boardingTurn: BoardingTurn = BoardingTurn.FIRST
}
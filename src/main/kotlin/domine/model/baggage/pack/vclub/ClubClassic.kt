package domine.model.baggage.pack.vclub

import domine.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class ClubClassic(
    price: BigDecimal
    ) : VClub(price) {
    override val name: String = "ClubClassic"
    override val boardingTurn: BoardingTurn = BoardingTurn.SECOND
}
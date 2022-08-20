package domine.model.baggage.pack.vclub

import domine.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class ClubBasic(
    price: BigDecimal,
) : VClub(price) {
    override val name: String = "RegularBasic"
    override val boardingTurn: BoardingTurn = BoardingTurn.THIRD
}
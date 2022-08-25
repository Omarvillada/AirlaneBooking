package domine.model.baggage.pack.vclub

import domine.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class ClubPlus(
    price: BigDecimal
) : VClub(price) {
    override val name: String = "Plus"
    override val boardingTurn: BoardingTurn = BoardingTurn.FIRST
    override val price: BigDecimal
        get() {
            return super.price + BigDecimal(20)
        }


}
package domine.model.baggage.pack.vclub

import domine.model.baggage.pack.BoardingTurn
import domine.model.baggage.type.BaggageType
import java.math.BigDecimal

class Basic(name: String = "Basic VClub", price: BigDecimal) : VClub(name, price) {
    override val boardingTurn: BoardingTurn = BoardingTurn.THIRD
}
import domine.model.baggage.pack.BaggagePackage
import domine.model.baggage.pack.regular.Regular
import domine.model.baggage.pack.regular.RegularBasic
import domine.model.baggage.pack.regular.RegularClassic
import domine.model.baggage.pack.vclub.*
import java.math.BigDecimal

fun main() {
    val basicPrice = BigDecimal(200)
    val classicPrice = BigDecimal(400)

    val basicClub: VClub = ClubBasic(basicPrice)
    val clubClassicClub: VClub = ClubClassic(classicPrice)

    println(basicClub.name)
    println(basicClub.price)

    println(clubClassicClub.name)
    println(clubClassicClub.price)

    val regular: Regular = RegularBasic(basicPrice)
    val classic: Regular = RegularClassic(classicPrice)

    println(regular.name)
    println(regular.price)

    println(classic.name)
    println(classic.price)

    val plus: BaggagePackage = Plus(BigDecimal(500))
    println(plus.price)

    //No se puede crear instancias de clases abstractas
    //val vclub: VClub = VClub(basicPrice)
}
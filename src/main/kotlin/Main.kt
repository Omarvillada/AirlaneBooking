import domine.model.*
import domine.model.baggage.pack.BaggagePackage
import domine.model.baggage.pack.regular.Regular
import domine.model.baggage.pack.regular.RegularBasic
import domine.model.baggage.pack.regular.RegularClassic
import domine.model.baggage.pack.vclub.*
import domine.model.seat.Seat
import domine.model.seat.SeatClass
import domine.model.seat.SeatStatus
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.Month

fun main() {

    val flight = Flight(
        number = "Y4 708",
        airCraft = AirCraft("Airbus","A320"),
        price = BigDecimal(100.0),
        departureArrivalBooking = getAirportPair()
    )
    val flightFormatter = flight.format()
    println(flightFormatter)

    val ticket = Ticket(
        flight = flight,
        passenger = Passenger(
            name = "Ann",
            email = "ann@a.com",
            phone = "55554444"
        ),
        baggage = RegularBasic(BigDecimal(50)),
        Seat("2", BigDecimal(15), SeatStatus.RESERVED, seatClass = SeatClass.ECONOMY)
    )

    val ticketFormatted = ticket.format()
    println(ticketFormatted)

    /*val flights = listOf(
        flight,
        flight,
        flight
    )
    flightPrinter.print(flights)*/


    /**
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
    **/
    //No se puede crear instancias de clases abstractas
    //val vclub: VClub = VClub(basicPrice)
}
fun getAirportPair(): Pair<AirportBooking, AirportBooking> {
    return Pair(
        AirportBooking(
            airport = Airport("BOG", "Bogotá"),
            dateTime = LocalDateTime.of(
                2023, Month.JANUARY, 10, 13, 0, 0
            )
        ),
        AirportBooking(
            airport = Airport("CUN", "Cancún"),
            dateTime = LocalDateTime.of(
                2023, Month.JANUARY, 10, 17, 30, 0
            )
        )
    )
}
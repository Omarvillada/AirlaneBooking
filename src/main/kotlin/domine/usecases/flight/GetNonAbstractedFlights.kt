package domine.usecases.flight

import domine.model.AirCraft
import domine.model.Airport
import domine.model.AirportBooking
import domine.model.Flight
import presentation.PresentationFormat
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.Month
import java.time.format.DateTimeFormatter

// No tenemos interfaz padre en común, tenemos que validar caso por caso
class GetNoAbstractedFlights(
    private val format: PresentationFormat
) {

    fun invoke() {

        val f = Flight(
            number = "Y4 708",
            airCraft = AirCraft("Airbus", "A320"),
            price = BigDecimal(100.0),
            departureArrivalBooking = getAirportPair()
        )

        val flightFormat = when (format) {
            PresentationFormat.CONSOLE -> {
                val departure = f.departureArrivalBooking.first
                val arrival = f.departureArrivalBooking.second
                """
                ${f.number}
                Origin: ${departure.airport.name}
                Destination: ${arrival.airport.name}
                Departure: ${departure.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}
                Arrival Date: ${arrival.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}
                Duration: ${f.duration}
                Price: $${f.price}
                
            """.trimIndent()
            }
            PresentationFormat.HTML -> {
                val departure = f.departureArrivalBooking.first
                val arrival = f.departureArrivalBooking.second
                """
                <p><strong>${f.number}</strong><br />
                Origin: ${departure.airport.name}<br />
                Destination: ${arrival.airport.name}<br />
                Departure: ${departure.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}<br />
                Arrival Date: ${arrival.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}<br />
                Duration: ${f.duration}<br />
                <strong>Price: ${'$'}${f.price}</strong>
                </p>
                
            """.trimIndent()
            }
            PresentationFormat.JSON -> {
                "{---}"
            }
            else -> ""

        }

        val flights = listOf(
            f,
            f,
            f
        )
    }

    private fun getAirportPair(): Pair<AirportBooking, AirportBooking> {
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
}
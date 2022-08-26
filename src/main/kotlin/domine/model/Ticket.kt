package domine.model

import domine.model.baggage.pack.BaggagePackage
import domine.model.seat.Seat
import java.math.BigDecimal


 class Ticket {
     lateinit var  flight: Flight
     lateinit var passenger: Passenger
     lateinit var baggagePackage: BaggagePackage
     lateinit var seat: Seat
     var totalPrice: BigDecimal = BigDecimal(0)// = flight.price + baggage.price + seat.price
     get() {
         return if (this::flight.isInitialized && this::baggagePackage.isInitialized && this::seat.isInitialized)
             flight.price + baggagePackage.price + seat.price
         else BigDecimal(0)

     }
 }


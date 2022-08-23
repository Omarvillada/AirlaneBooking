package presentation.flight

import domine.model.Flight
import domine.presentation.Formatter
import presentation.PresentationFormat

class FlightPresentationFactory {
    fun getPresentationFormat(format: PresentationFormat): Formatter<Flight>{
        return when(format) {
            PresentationFormat.CONSOLE -> FlightConsoleFormat()
            PresentationFormat.HTML -> FlightHTMLFormat()
            else -> FlightConsoleFormat()
        }
    }
}
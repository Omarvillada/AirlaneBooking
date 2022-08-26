package presentation.menu

import presentation.extfunction.isMenuOptionValid
import presentation.flight.formats.FlightConsoleFormat
import presentation.utils.Formatter


interface UIMenu<T> {

    fun showMenu(
        mapObject: Map<Int, T>,
        formatter: Formatter<T>
    ): T? {
        var option: String = ""
        do {

            mapObject.forEach { t, u ->
                print("$t. ")
                println(formatter.format(u))
            }
            println("*** Select Number Option ***")
            option = readLine().orEmpty()


        }while (!option.isMenuOptionValid(mapObject))
        return mapObject[option.toInt()]
    }
}
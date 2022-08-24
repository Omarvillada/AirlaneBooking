import data.baggage.BaggageVClubLocalSource
import domine.usecases.baggage.GetBaggagePackage
import presentation.baggage.BaggagePackageConsole
import presentation.baggage.types.BaggageTypesConsole

fun main() {

    val vClubLocalSource = BaggageVClubLocalSource()
    val getVClubPackages = GetBaggagePackage(vClubLocalSource).invoke()

    println("*** VClub Baggage´s ***")
    getVClubPackages.forEach {(t, u) ->
        print("$t. ")
        println(
            BaggagePackageConsole(
                BaggageTypesConsole()
            ).format(u)
        )
    }
}

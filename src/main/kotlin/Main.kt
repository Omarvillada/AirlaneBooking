import data.baggage.BaggageRegularLocalSource
import data.baggage.BaggageVClubLocalSource
import domine.usecases.baggage.GetBaggagePackage
import presentation.baggage.BaggagePackageConsole
import presentation.baggage.types.BaggageTypesConsole

fun main() {






/*
    val vClubLocalSource = BaggageVClubLocalSource()
    val getVClubPackages = GetBaggagePackage(vClubLocalSource).invoke()

    println("*** VClub Baggage´s ***")
    getVClubPackages.forEach {(t, u) ->
        print("$t. ")

        println(
            BaggagePackageConsole(
                BaggageTypesConsole()
            ).format(u))
    }

    val regularLocalSource = BaggageRegularLocalSource()
    val getRegularPackages = GetBaggagePackage(regularLocalSource).invoke()
    println()
    println("*** Regular Baggage´s ***")
    getRegularPackages.forEach {(t, u) ->
        print("$t. ")
        println(
            BaggagePackageConsole(
                BaggageTypesConsole()
            ).format(u))
    }

 */
}

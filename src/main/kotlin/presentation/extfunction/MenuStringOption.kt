package presentation.extfunction

import domine.model.Flight

fun String.isNotBlankOrEmpty(): Boolean {
    return this.isNotEmpty() || this.isNotBlank()
}

fun String.isNumber(): Boolean {
    return this.all { it.isDigit() }
}

fun String.isMenuOptionValid(flightsMap: Map<Int, Flight>): Boolean {
    return if(isNotBlankOrEmpty()) {
        val isValidOption = isNumber() && flightsMap.containsKey(this.toInt())
        return isValidOption
    }else false
}
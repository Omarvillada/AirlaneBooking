package presentation.extfunction

fun String.isBlankOrEmpty(): Boolean {
    return this.isBlank() || this.isEmpty()
}

fun String.isNotBlankOrEmpty(): Boolean {
    return this.isNotEmpty() || this.isNotBlank()
}

fun String.isNumber(): Boolean {
    return this.all { it.isDigit() }
}

fun <T> String.isMenuOptionValid(mapObjects: Map<Int, T>): Boolean {
    return if(isNotBlankOrEmpty()) {
        val isValidOption = isNumber() && mapObjects.containsKey(this.toInt())
        return isValidOption
    }else false
}
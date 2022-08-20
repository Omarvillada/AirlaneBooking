package domine.model.baggage.pack

enum class BoardingTurn(
    val message: String,
) {
    FIRST("Aborda primero"),
    SECOND("Aborda segundo"),
    THIRD("Aborda segundo"),
    END("Aborda al final"),
}
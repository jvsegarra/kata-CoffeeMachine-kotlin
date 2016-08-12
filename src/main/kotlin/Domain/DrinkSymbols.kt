package Domain

val currentDrinksPrices = mapOf<String, Float>(
        "T" to 0.4f,
        "C" to 0.6f,
        "H" to 0.5f,
        "Th" to 0.4f,
        "Ch" to 0.6f,
        "Hh" to 0.5f,
        "O" to 0.6f
)

class DrinkSymbols {
    companion object {
        fun listOfAvailableDrinks(): List<String> = currentDrinksPrices.keys.toList()
        fun currentPriceForDrink(drink: String): Float = currentDrinksPrices[drink] ?: 0.0f
    }
}

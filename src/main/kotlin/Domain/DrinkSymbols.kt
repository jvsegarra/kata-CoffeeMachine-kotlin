package Domain

val currentDrinksPrices = mapOf<Char, Float>(
        'T' to 0.4f,
        'C' to 0.6f,
        'H' to 0.5f
)

class DrinkSymbols {
    companion object {
        fun listOfAvailableDrinks(): List<Char> = currentDrinksPrices.keys.toList()
        fun currentPriceForDrink(drink: Char): Float = currentDrinksPrices[drink] ?: 0.0f
    }
}

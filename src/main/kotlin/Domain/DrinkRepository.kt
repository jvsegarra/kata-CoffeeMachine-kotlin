package Domain

import Domain.Entity.Drink

interface DrinkRepository {
    var drinksList: MutableList<Drink>

    fun addDrink(drink: Drink)
    fun drinksSold(): String
    fun moneyEarned(): String
}

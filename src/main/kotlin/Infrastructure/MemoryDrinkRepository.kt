package Infrastructure

import Domain.DrinkRepository
import Domain.DrinkSymbols
import Domain.Entity.Drink
import Domain.Entity.Order

class MemoryDrinkRepository : DrinkRepository {
    override var drinksList: MutableList<Drink> = mutableListOf()

    override fun addDrink(drink: Drink) {
        drinksList.add(drink)
    }

    override fun drinksSold(): String {
        return drinksList.groupBy { it.code }.map { "${it.key}:${it.value.count()}" }.joinToString()
    }

    override fun moneyEarned(): String {
        return drinksList.map { DrinkSymbols.currentPriceForDrink(it.code) }.sum().toString()
    }
}
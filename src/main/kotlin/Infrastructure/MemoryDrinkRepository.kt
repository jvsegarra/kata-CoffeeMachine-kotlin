package Infrastructure

import Domain.DrinkRepository
import Domain.Entity.Order

class MemoryDrinkRepository : DrinkRepository {
    override var ordersList: List<Order> = listOf()

    override fun drinksSold(): String {
        return ""
    }

    override fun moneyEarned(): String {
        return ""
    }
}
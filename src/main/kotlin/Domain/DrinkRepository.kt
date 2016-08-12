package Domain

import Domain.Entity.Order

interface DrinkRepository {
    var ordersList: List<Order>

    fun drinksSold(): String
    fun moneyEarned(): String
}

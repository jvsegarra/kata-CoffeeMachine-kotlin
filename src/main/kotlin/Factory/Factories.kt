package Factory

import Domain.Entity.Drink
import Domain.Entity.Order

//-------- Drink
fun createDrinkFromCode(code: Char): Drink = Drink(code)

//-------- Order
fun createOrderFromDrinkAndQuantity(drink: Drink, sugarQuantity: Int): Order = Order(drink, sugarQuantity)

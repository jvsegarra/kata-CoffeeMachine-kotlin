package Factory

import Domain.Entity.Drink
import Domain.Entity.Order

//-------- Drink
fun createDrinkFromCode(code: String): Drink = Drink(code)

//-------- Order
fun createOrderFromCommand(command: String): Order {
    val orderParams = command.split(':')
    return Order(
            createDrinkFromCode(orderParams[0]),
            orderParams[1].toInt(),
            orderParams[3].toFloat()
    )
}

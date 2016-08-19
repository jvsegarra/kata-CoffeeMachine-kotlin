package Infrastructure

import Domain.DrinkMaker
import Domain.DrinkRepository
import Domain.DrinkSymbols
import Factory.createOrderFromCommand

class CoffeeMachineDrinkMaker(val drinkRepository: DrinkRepository) : DrinkMaker{
    override fun makeDrink(command: String): String {
        val order = createOrderFromCommand(command)
        val priceDifference = order.price - DrinkSymbols.currentPriceForDrink(order.drink.code)

        if (priceDifference > 0.0f) {
            drinkRepository.addDrink(order.drink)
            return "M:drink made. your change is: ${priceDifference.toString().format("%.1f")}"
        } else if (priceDifference < 0.0f) {
            return "M:not enough money"
        }

        drinkRepository.addDrink(order.drink)
        return "M:drink made"
    }
}

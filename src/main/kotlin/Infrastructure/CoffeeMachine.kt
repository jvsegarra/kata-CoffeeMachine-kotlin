package Infrastructure

import Domain.DrinkMaker

class CoffeeMachine : DrinkMaker {
    override fun makeDrink(command: String): String {
        return "M:drink made"
    }
}
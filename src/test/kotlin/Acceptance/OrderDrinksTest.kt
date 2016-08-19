package Acceptance

import Domain.Entity.Drink
import Domain.Entity.Order
import Infrastructure.CoffeeMachineDrinkMaker
import Infrastructure.MemoryDrinkRepository
import io.kotlintest.specs.FunSpec
import kotlin.test.assertEquals

class OrderDrinksTest : FunSpec() {
    init {
        test("Customers should be able to order tea with one sugar") {
            val order = Order(Drink("T"), 1, 0.4f)
            val result = CoffeeMachineDrinkMaker(MemoryDrinkRepository()).makeDrink(order.toCommandString())
            assertEquals("M:drink made", result)
        }

        test("Customers should be able to order chocolate with no sugar") {
            val order = Order(Drink("H"), 0, 0.5f)
            val result = CoffeeMachineDrinkMaker(MemoryDrinkRepository()).makeDrink(order.toCommandString())
            assertEquals("M:drink made", result)
        }

        test("Customers should be able to order coffee with two sugars") {
            val order = Order(Drink("C"), 2, 0.6f)
            val result = CoffeeMachineDrinkMaker(MemoryDrinkRepository()).makeDrink(order.toCommandString())
            assertEquals("M:drink made", result)
        }

        test("Customers should be able to order orange juice") {
            val order = Order(Drink("O"), 2, 0.6f)
            val result = CoffeeMachineDrinkMaker(MemoryDrinkRepository()).makeDrink(order.toCommandString())
            assertEquals("M:drink made", result)
        }

        test("Customers should be able to order extra hot coffee with no sugar") {
            val order = Order(Drink("Ch"), 0, 0.6f)
            val result = CoffeeMachineDrinkMaker(MemoryDrinkRepository()).makeDrink(order.toCommandString())
            assertEquals("M:drink made", result)
        }

        test("Customers should be able to order extra hot chocolate with one sugar") {
            val order = Order(Drink("Hh"), 1, 0.5f)
            val result = CoffeeMachineDrinkMaker(MemoryDrinkRepository()).makeDrink(order.toCommandString())
            assertEquals("M:drink made", result)
        }

        test("Customers should be able to order extra hot tea with two sugar") {
            val order = Order(Drink("Th"), 2, 0.4f)
            val result = CoffeeMachineDrinkMaker(MemoryDrinkRepository()).makeDrink(order.toCommandString())
            assertEquals("M:drink made", result)
        }

        test("Customers should get an error when not enough money is provided") {
            val order = Order(Drink("C"), 2, 0.1f)
            val result = CoffeeMachineDrinkMaker(MemoryDrinkRepository()).makeDrink(order.toCommandString())
            assertEquals("M:not enough money", result)
        }

        test("Customers should get a message with the change when more money is provided") {
            val order = Order(Drink("C"), 2, 1.0f)
            val result = CoffeeMachineDrinkMaker(MemoryDrinkRepository()).makeDrink(order.toCommandString())
            assertEquals("M:drink made. your change is: 0.4", result)
        }

        test("Coffee machine should return the correct list of drinks sold") {
            val coffeeMachine = CoffeeMachineDrinkMaker(MemoryDrinkRepository())
            coffeeMachine.makeDrink(Order(Drink("C"), 2, 0.6f).toCommandString())
            coffeeMachine.makeDrink(Order(Drink("T"), 2, 0.4f).toCommandString())
            coffeeMachine.makeDrink(Order(Drink("C"), 2, 0.6f).toCommandString())
            coffeeMachine.makeDrink(Order(Drink("H"), 2, 0.5f).toCommandString())
            coffeeMachine.makeDrink(Order(Drink("Ch"), 2, 0.6f).toCommandString())
            coffeeMachine.makeDrink(Order(Drink("C"), 2, 0.6f).toCommandString())

            val result = coffeeMachine.drinkRepository.drinksSold()
            assertEquals("C:3, T:1, H:1, Ch:1", result)
        }

        test("Coffee machine should return the correct amount of money earned") {
            val coffeeMachine = CoffeeMachineDrinkMaker(MemoryDrinkRepository())
            coffeeMachine.makeDrink(Order(Drink("C"), 2, 0.6f).toCommandString())
            coffeeMachine.makeDrink(Order(Drink("T"), 2, 0.4f).toCommandString())
            coffeeMachine.makeDrink(Order(Drink("C"), 2, 0.6f).toCommandString())
            coffeeMachine.makeDrink(Order(Drink("H"), 2, 0.5f).toCommandString())
            coffeeMachine.makeDrink(Order(Drink("Ch"), 2, 0.6f).toCommandString())
            coffeeMachine.makeDrink(Order(Drink("C"), 2, 0.6f).toCommandString())

            val result = coffeeMachine.drinkRepository.moneyEarned()
            assertEquals("money earned: 3.3", result)
        }
    }
}

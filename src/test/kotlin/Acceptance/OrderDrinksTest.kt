package Acceptance

import Domain.Entity.Drink
import Domain.Entity.Order
import Infrastructure.CoffeeMachineDrinkMaker
import io.kotlintest.specs.FunSpec
import kotlin.test.assertEquals

class OrderDrinksTest : FunSpec() {
    init {
        test("Customers should be able to order tea with one sugar") {
            val order = Order(Drink("T"), 1, 0.4f)
            val result = CoffeeMachineDrinkMaker().makeDrink(order.toCommandString())
            assertEquals("M:drink made", result)
        }

        test("Customers should be able to order chocolate with no sugar") {
            val order = Order(Drink("H"), 0, 0.5f)
            val result = CoffeeMachineDrinkMaker().makeDrink(order.toCommandString())
            assertEquals("M:drink made", result)
        }

        test("Customers should be able to order coffee with two sugars") {
            val order = Order(Drink("C"), 2, 0.6f)
            val result = CoffeeMachineDrinkMaker().makeDrink(order.toCommandString())
            assertEquals("M:drink made", result)
        }

        test("Customers should be able to order orange juice") {
            val order = Order(Drink("O"), 2, 0.6f)
            val result = CoffeeMachineDrinkMaker().makeDrink(order.toCommandString())
            assertEquals("M:drink made", result)
        }

        test("Customers should be able to order extra hot coffee with no sugar") {
            val order = Order(Drink("Ch"), 0, 0.6f)
            val result = CoffeeMachineDrinkMaker().makeDrink(order.toCommandString())
            assertEquals("M:drink made", result)
        }

        test("Customers should be able to order extra hot chocolate with one sugar") {
            val order = Order(Drink("Hh"), 1, 0.5f)
            val result = CoffeeMachineDrinkMaker().makeDrink(order.toCommandString())
            assertEquals("M:drink made", result)
        }

        test("Customers should be able to order extra hot tea with two sugar") {
            val order = Order(Drink("Th"), 2, 0.4f)
            val result = CoffeeMachineDrinkMaker().makeDrink(order.toCommandString())
            assertEquals("M:drink made", result)
        }

        test("Customers should get an error when not enough money is provided") {
            val order = Order(Drink("C"), 2, 0.1f)
            val result = CoffeeMachineDrinkMaker().makeDrink(order.toCommandString())
            assertEquals("M:not enough money", result)
        }

        test("Customers should get a message with the change when more money is provided") {
            val order = Order(Drink("C"), 2, 1.0f)
            val result = CoffeeMachineDrinkMaker().makeDrink(order.toCommandString())
            assertEquals("M:drink made. your change is: 0.4", result)
        }
    }
}

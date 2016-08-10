package Acceptance

import Domain.Entity.Drink
import Domain.Entity.Order
import Infrastructure.CoffeeMachine
import io.kotlintest.specs.FunSpec
import kotlin.test.assertEquals

class OrderDrinksTest : FunSpec() {
    init {
        test("Customers should be able to order tea with one sugar") {
            val order = Order(Drink('T'), 1)
            val result = CoffeeMachine().makeDrink(order.toCommandString())
            assertEquals("M:drink made", result)
        }

        test("Customers should be able to order chocolate with no sugar") {
            val order = Order(Drink('H'), 0)
            val result = CoffeeMachine().makeDrink(order.toCommandString())
            assertEquals("M:drink made", result)
        }

        test("Customers should be able to order coffee with two sugars") {
            val order = Order(Drink('C'), 2)
            val result = CoffeeMachine().makeDrink(order.toCommandString())
            assertEquals("M:drink made", result)
        }
    }
}

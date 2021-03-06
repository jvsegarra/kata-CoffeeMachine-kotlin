package Domain.Entity

//-------- Drink
class Drink(val code: String)


//-------- Order
class Order(val drink: Drink, val sugarQuantity: Int, val price: Float) {
    val sticks: Int = 0

    fun toCommandString(): String {
        return "${this.drink.code}:${this.sugarQuantity}:${this.sticks}:${this.price}"
    }
}

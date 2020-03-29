package chapter01

class CreditCard {
  def charge(price: Double) = {
    println(s"Charging ${price}")
    price
  }
}

class Coffee {
  val price: Double = 0.90
}

class Cafe {
  def buyCoffee(cc: CreditCard): Coffee = {
    val cup = new Coffee
    cc.charge(cup.price)
    cup
  }
}

object CoffeeMachineApp extends App {
  println("~~~ This is CoffeeMachine example. ~~~")

  val cafe = new Cafe
  val creditCard = new CreditCard
  cafe.buyCoffee(creditCard)
  cafe.buyCoffee(creditCard)
  cafe.buyCoffee(new CreditCard)
}

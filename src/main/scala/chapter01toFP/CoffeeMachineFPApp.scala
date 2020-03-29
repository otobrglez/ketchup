package chapter01toFP


class CreditCard {
  def charge = ???
}

class Coffee {
  val price: Double = .90

  override def toString: String = s"[Coffee: ${price}]"
}

case class Charge(cc: CreditCard, amount: Double) {
  def combine(other: Charge): Charge =
    if (cc == other.cc)
      Charge(cc, amount + other.amount)
    else
      throw new Exception("Can't combine charges from different cards")

  override def toString: String = s"[Charge: ${amount} to ${cc}]"
}

class Cafe {
  def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
    val cup = new Coffee
    (cup, Charge(cc, cup.price))
  }

  def buyCoffees(cc: CreditCard, n: Int): (List[Coffee], Charge) = {
    val purchases: List[(Coffee, Charge)] = List.fill(n)(buyCoffee(cc))
    val (coffees, charges) = purchases.unzip
    (coffees, charges.reduce((c1, c2) => c1.combine(c2)))
  }
}

object CoffeeMachineFPApp extends App {
  println(s"~~~~~ ${getClass.getCanonicalName} ~~~~~")

  val cafe = new Cafe
  val myCreditCard = new CreditCard
  val anotherCreditCard = new CreditCard

  cafe.buyCoffee(myCreditCard)
  cafe.buyCoffee(myCreditCard)
  cafe.buyCoffee(anotherCreditCard)

  val receipt = cafe.buyCoffees(myCreditCard, 10)
  println(s"Coffees = ${receipt._1.mkString(",")}")
  println(s"Charge = ${receipt._2}")
}

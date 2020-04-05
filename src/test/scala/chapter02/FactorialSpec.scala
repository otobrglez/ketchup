package chapter02

import org.scalatest.flatspec._
import org.scalatest.matchers.should.Matchers

class FactorialSpec extends AnyFlatSpec with Matchers {
  "Factorial" should "work" in {
    Factorial.factorial(9) shouldEqual 362880
  }
}

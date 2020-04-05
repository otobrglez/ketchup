package chapter02

import org.scalatest.flatspec._
import org.scalatest.matchers.should.Matchers

class HOFSpec extends AnyFlatSpec with Matchers {
  "High-order functions (HOF)" should "curry" in {
    val FCurried = HOF.curry((a: Int, b: Int) => a == b)
    FCurried(20)(20)
  }

  it should "uncurry" in {
    val FCurried = HOF.curry((a: Int, b: Int) => a == b)
    val FUnCurried = HOF.uncurry(FCurried)
    FUnCurried(20, 20)
  }

  it should "compose" in {
    HOF.compose((a: Int) => a + 10, (b: Int) => b * 2)(1)

    val f1: Int => Int = _ + 10
    val f2: Int => Int = _ * 2
    val f3 = f1.compose(f2)

    f3(1) shouldEqual 12
    HOF.compose(f1, f2)(1) shouldEqual 12
  }
}

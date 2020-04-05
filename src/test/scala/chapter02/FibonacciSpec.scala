package chapter02

import org.scalatest.flatspec._
import org.scalatest.matchers.should.Matchers

class FibonacciSpec extends AnyFlatSpec with Matchers {
  "Fibonacci" should "work" in {
    Fibonacci.fib(9) shouldEqual 34
  }

  it should "work with RT" in {
    Fibonacci.fibTR(9) shouldEqual Fibonacci.fib(9)
  }
}

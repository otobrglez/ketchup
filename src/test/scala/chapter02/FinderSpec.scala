package chapter02

import org.scalatest.flatspec._
import org.scalatest.matchers.should.Matchers

class FinderSpec extends AnyFlatSpec with Matchers {
  "Finder" should "findFirst" in {
    val l = List(9, 1, 2, 3, 42, 4, 2)
    Finder.findFirst(l)((n: Int) => n == 42) shouldEqual 4
    Finder.findFirst(l)((n: Int) => n == 999) shouldEqual -1
  }

  it should "without synthetic sugar" in {
    val listOfIntegers = List(9, 1, 2, 3, 42, 4, 2)

    val leftSmallerThenRight = new Function2[Int, Int, Boolean] {
      override def apply(a: Int, b: Int): Boolean = a < b
    }

    Finder.isSorted(listOfIntegers.toArray.sorted)(leftSmallerThenRight) shouldEqual false
  }

  it should "isSorted" in {
    val list = List(9, 1, 2, 3, 42, 4, 2)
    Finder.isSorted(list)(_ > _) shouldEqual false
  }
}

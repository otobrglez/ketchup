package chapter03

import org.scalatest.flatspec._
import org.scalatest.matchers.should.Matchers

class ListSpec extends AnyFlatSpec with Matchers {
  "List" should "setHead" in {
    List.setHead(List(1, 2, 3), 41) shouldEqual List(41, 1, 2, 3)
  }

  it should "foreach" in {
    val l = List(1, 2, 3)
    List.foreach(l)(_ => "x")
  }

  it should "tail" in {
    val l = List(1, 2, 3, 42)
    List.tail(l) shouldEqual List(2, 3, 42)
  }

  it should "drop" in {
    List.drop(List(1, 2, 3), 2) shouldEqual List(3)
  }

  it should "dropWhile" in {
    val l = List(1, 2, 3, 4)
    List.dropWhile(l)(_ <= 3) shouldEqual List(4)
  }

  it should "init" in {
    val l = List.init(List(1, 2, 3, 42))
    l shouldEqual List(1, 2, 3, 42)
  }

  it should "map" in {
    List.map(List(1, 2, 3))(_ * 2) shouldEqual List(2, 4, 6)
    List.map(List("a", "b", "c"))(_.toUpperCase)
  }

  it should "foldLeft" in {
    List.foldLeft(List(1, 2, 3), 0)((c, acc) => acc + c) shouldEqual 6
  }

  it should "foldRight" in {
    List.foldRight(List(1, 2, 3), 0)((acc, c) => acc + c) shouldEqual 6
  }

  it should "length" in {
    List.length(List(1, 2, 3, 4)) shouldEqual 4
  }

  it should "product" in {
    List.product(List(1, 2, 3)) shouldEqual 6
  }

  it should "append" in {
    List.append(List(1, 2), List(3, 4)) shouldEqual List(1, 2, 3, 4)
  }
}

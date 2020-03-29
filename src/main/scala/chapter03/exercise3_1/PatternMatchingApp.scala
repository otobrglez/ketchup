package chapter03.exercise3_1

import chapter03.datastructures.{MList, _}


object PatternMatchingApp {
  def main(args: Array[String]): Unit = {

    val x = MList(Range(1, 6).toList: _*) match {
      case Cons(x, Cons(2, Cons(4, _))) => x
      case Nil => 42
      case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y // <- this
      case Cons(h, t) => h + MList.sum(t)
      case _ => 101
    }

    println(x)
  }
}

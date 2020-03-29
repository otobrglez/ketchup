package chapter03.datastructures

sealed trait MList[+A]

case object Nil extends MList[Nothing]

case class Cons[+A](head: A, tail: MList[A]) extends MList[A]


object MList {
  def apply[A](as: A*): MList[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def sum(ints: MList[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: MList[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(.0, _) =>.0
    case Cons(x, xs) => x * product(xs)
  }

  def foreach[A, U](mList: MList[A], f: A => U): Unit = {
    @scala.annotation.tailrec
    def loop(mList: MList[A], f: A => U): Unit = mList match {
      case Cons(x, xs) =>
        f(x)
        loop(xs, f)
      case _ => ()
    }

    loop(mList, f)
  }

  def map[A, B](mList: MList[A], f: A => B): MList[B] = {
    def loop(mList: MList[A], f: A => B): MList[B] = mList match {
      case Cons(x, xs) => Cons(f(x), loop(xs, f))
      case Nil => Nil
    }

    loop(mList, f)
  }
}

object SampleApp {
  def main(args: Array[String]): Unit = {
    println("~~~ Exploring data structures ~~~")

    val a = MList(1, 2, 3, 4)
    val b = MList("Oto", "Martina", "Rudi", "Tinkara")

    MList.foreach(a, (a: Int) => println(a))
    MList.foreach(b, (b: String) => println(b))

    List(42, 43, 3).foreach(println(_))
    List(1, 2, 3).map(_ * 2).foreach(println(_))

    println(s"Sum of MList a ~> ${MList.sum(a)}")
    println(s"Product of MList ~> ${MList.product(MList(1.0, 2.0, 3.0))}")

    def printList[A](mList: MList[A]): Unit = MList.foreach(mList, (a: A) => println(a))

    printList(a)
    printList(b)

    printList(MList.map(a, (n: Int) => n * 2))
    printList(MList.map(b, (s: String) => s.toUpperCase))
  }
}

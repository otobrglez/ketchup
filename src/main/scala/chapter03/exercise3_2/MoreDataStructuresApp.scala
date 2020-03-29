package chapter03.exercise3_2

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  @scala.annotation.tailrec
  def foreach[A, B](list: List[A], f: A => B): Unit = list match {
    case Cons(x, xs) => f(x); foreach(xs, f)
    case Nil => Nil
  }

  def print[A](list: List[A]): Unit = foreach(list, (x: A) => println(x))

  def tail[A](list: List[A]): List[A] = list match {
    case Cons(_, tail) => tail
    case _ => Nil
  }

  def setHead[A](list: List[A], newX: A): List[A] = list match {
    case Cons(_, tail) => Cons(newX, tail)
    case _ => Cons(newX, Nil)
  }

  // TODO: Implement
  def drop[A](list: List[A], n: Int): List[A] = ???
  def dropWhile[A](list: List[A], f: A => Boolean): List[A] = ???
  def init[A](list: List[A]): List[A] = ???
}

object MoreDataStructuresApp {

  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4)
    val letters = List("a", "b", "c", "d")
    val people = List("Oto", "Rudi", "Martina", "Tinkara")

    List.foreach(numbers, (n: Int) => println(n))
    List.print(letters)
    List.print(people)

    List.print(List.tail(people))

    List.print(List.setHead(numbers, 42))
    List.print(List.setHead(List(), 42))
  }
}

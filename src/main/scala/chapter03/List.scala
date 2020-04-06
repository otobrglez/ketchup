package chapter03

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def init[A](list: List[A]): List[A] = list match {
    case Cons(x, tail) => Cons(x, init(tail))
    case Nil => Nil
  }

  @scala.annotation.tailrec
  def foreach[A, B](list: List[A])(f: A => B): Unit = list match {
    case Cons(x, xs) => f(x); foreach(xs)(f)
    case Nil => Nil
  }

  def print[A](list: List[A]): Unit = foreach(list)(println(_))

  def tail[A](list: List[A]): List[A] = list match {
    case Cons(_, tail) => tail
    case _ => Nil
  }

  def setHead[A](list: List[A], newX: A): List[A] = list match {
    case Cons(x, tail) => Cons(newX, Cons(x, tail))
    case _ => Cons(newX, Nil)
  }

  @scala.annotation.tailrec
  def drop[A](list: List[A], n: Int): List[A] =
    if (n <= 0) list
    else list match {
      case Cons(_, tail) => drop(tail, n - 1)
      case _ => Nil
    }

  @scala.annotation.tailrec
  def dropWhile[A](list: List[A])(f: A => Boolean): List[A] = list match {
    case Cons(x, tail) if f(x) => dropWhile(tail)(f)
    case _ => list
  }

  def filter[A](list: List[A])(f: A => Boolean): List[A] =
    foldRight(list, Nil: List[A])((x, tail) => if (f(x)) Cons(x, tail) else tail)

  def map[A, B](list: List[A])(f: A => B): List[B] = list match {
    case Cons(x, tail) => Cons(f(x), map(tail)(f))
    case _ => Nil
  }

  def foldRight[A, B](list: List[A], z: B)(f: (A, B) => B): B = list match {
    case Nil => z
    case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  }

  def foldLeft[A, B](list: List[A], z: B)(f: (A, B) => B): B = {
    @scala.annotation.tailrec
    def loop(l: List[A], z: B, acc: B): B = l match {
      case Nil => acc
      case Cons(x, xs) => loop(xs, z, f(x, acc))
    }

    loop(list, z, z)
  }

  def length[A](list: List[Int]): Int = foldRight(list, 0)((_, acc) => acc + 1)

  def product(list: List[Double]): Double = foldRight(list, 1.0)((c, acc) => c * acc)

  def append[A](listA: List[A], listB: List[A]): List[A] = listA match {
    case Nil => listB
    case Cons(x, tail) => Cons(x, append(tail, listB))
  }
}

sealed trait List[+A]
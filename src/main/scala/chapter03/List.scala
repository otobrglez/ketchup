package chapter03

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def init[A](as: List[A]): List[A] = as match {
    case Cons(x, tail) => Cons(x, init(tail))
    case Nil => Nil
  }

  @scala.annotation.tailrec
  def foreach[A, B](as: List[A])(f: A => B): Unit = as match {
    case Cons(x, xs) => f(x); foreach(xs)(f)
    case Nil => Nil
  }

  def print[A](as: List[A]): Unit = foreach(as)(println(_))

  def tail[A](as: List[A]): List[A] = as match {
    case Cons(_, tail) => tail
    case _ => Nil
  }

  def setHead[A](as: List[A], newX: A): List[A] = as match {
    case Cons(x, tail) => Cons(newX, Cons(x, tail))
    case _ => Cons(newX, Nil)
  }

  @scala.annotation.tailrec
  def drop[A](as: List[A], n: Int): List[A] =
    if (n <= 0) as
    else as match {
      case Cons(_, tail) => drop(tail, n - 1)
      case _ => Nil
    }

  @scala.annotation.tailrec
  def dropWhile[A](as: List[A])(f: A => Boolean): List[A] = as match {
    case Cons(x, tail) if f(x) => dropWhile(tail)(f)
    case _ => as
  }

  def filter[A](as: List[A])(f: A => Boolean): List[A] =
    foldRight(as, Nil: List[A])((x, tail) => if (f(x)) Cons(x, tail) else tail)

  def map[A, B](as: List[A])(f: A => B): List[B] = as match {
    case Cons(x, tail) => Cons(f(x), map(tail)(f))
    case _ => Nil
  }

  def reverse[A](as: List[A]): List[A] =
    foldLeft(as, Nil: List[A])((ls, x) => Cons(x, ls))

  def flatMap[A, B](as: List[A])(f: A => List[B]): List[B] =
    foldLeft(reverse(as), Nil: List[B])((rs, a) => append(f(a), rs))

  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = as match {
    case Nil => z
    case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  }

  @annotation.tailrec
  def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = as match {
    case Nil => z
    case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
  }

  def length[A](as: List[Int]): Int = foldRight(as, 0)((_, acc) => acc + 1)

  def product(as: List[Double]): Double = foldRight(as, 1.0)((c, acc) => c * acc)

  def append[A](as: List[A], bs: List[A]): List[A] = as match {
    case Nil => bs
    case Cons(x, tail) => Cons(x, append(tail, bs))
  }
}

sealed trait List[+A]
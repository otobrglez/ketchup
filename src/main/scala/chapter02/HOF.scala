package chapter02

object HOF {
  // Exercise 2.3 - implement curry
  def curryStd[A, B, C](f: (A, B) => C): A => B => C =
    f.curried

  // Exercise 2.3 - implement curry (no Scala STD)
  def curry[A, B, C](f: (A, B) => C): A => B => C =
    a => b => f(a, b)

  // Exercise 2.4
  def uncurry[A, B, C](f: A => B => C): (A, B) => C =
    (a, b) => f(a)(b)

  // Exercise 2.5
  def compose[A, B, C](f: B => C, g: A => B): A => C =
    a => f(g(a))
}

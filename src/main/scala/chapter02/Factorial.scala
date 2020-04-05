package chapter02

object Factorial {
  def factorial(n: Int): Int = {
    @scala.annotation.tailrec
    def go(n: Int, acc: Int = 1): Int =
      if (n <= 0) acc
      else go(n - 1, n * acc)

    go(n)
  }
}

package chapter02

object Fibonacci {
  def fib(n: Int): Int = {
    def go(n: Int): Int =
      if (n <= 1) n else go(n - 1) + go(n - 2)

    go(n)
  }

  /**
   * N-th Fibonacci sequence number; computed using tail-recursion optimization.
   * @param i
   * @return
   */
  def fibTR(i: Int): Int = {
    @scala.annotation.tailrec
    def go(i: Int, previous: Int, current: Int): Int =
      if (i <= 1) current
      else go(i - 1, previous = previous + current, current = previous)

    go(i + 1, 1, 0)
  }
}

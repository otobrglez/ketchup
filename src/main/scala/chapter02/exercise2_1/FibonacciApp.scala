package chapter02.exercise2_1

object Factorial {
  def factorial(n: Int): Int = {
    @scala.annotation.tailrec
    def go(n: Int, acc: Int = 1): Int =
      if (n <= 0) acc
      else go(n - 1, n * acc)

    go(n)
  }
}

/**
 * static int fib(int n)
 * {
 * if (n <= 1)
 * return n;
 * return fib(n-1) + fib(n-2);
 * }
 */

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

object FibonacciApp {

  def main(args: Array[String]): Unit = {
    println("~~~ FibonacciApp ~~~")
    println(s"Factorial = ${Factorial.factorial(5)}")
    println(s"n-th Fibonacci = ${Fibonacci.fib(9)}")
    println(s"n-th Fibonacci = ${Fibonacci.fibTR(9)}")
  }
}

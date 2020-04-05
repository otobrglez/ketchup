package chapter02

/**
 * Exercise 2.2:
 * Implement "isSorted" which checks if an Array[T] is
 * sorted according to a given comparison function.
 */
object Finder {
  def findFirst[T](xs: List[T])(f: T => Boolean): Int = {
    @scala.annotation.tailrec
    def go(i: Int): Int =
      if (i >= xs.length) -1
      else if (f(xs(i))) i
      else go(i + 1)

    go(0)
  }

  def isSorted[T](as: Seq[T])(ordered: (T, T) => Boolean): Boolean = {
    @scala.annotation.tailrec
    def go(i: Int): Boolean =
      if (i >= as.length || i + 1 >= as.length) true
      else if (!ordered(as(i), as(i + 1))) false
      else go(i + 1)

    go(0)
  }
}

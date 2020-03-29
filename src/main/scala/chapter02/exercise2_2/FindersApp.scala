package chapter02.exercise2_2

sealed case class User(name: String)

/**
 * Exercise 2.2:
 * Implement "isSorted" which checks if an Array[T] is
 * sorted according to a given comparison function.
 */
object Finder {
  def findFirst[T](xs: List[T], f: T => Boolean): Int = {
    @scala.annotation.tailrec
    def go(i: Int): Int =
      if (i >= xs.length) -1
      else if (f(xs(i))) i
      else go(i + 1)

    go(0)
  }

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @scala.annotation.tailrec
    def go(i: Int): Boolean =
      if (i >= as.length || i + 1 >= as.length) true
      else if (!ordered(as(i), as(i + 1))) false
      else go(i + 1)

    go(0)
  }
}

object FindersApp {
  def main(args: Array[String]): Unit = {
    println("FindersApp...")

    val listOfIntegers = List(9, 1, 2, 3, 42, 4, 2)
    val listOfStrings = List("Oto", "Rudi", "Martina", "Tinkara")
    val listOfUser: List[User] = listOfStrings.map(User)

    println {
      Finder.findFirst(listOfIntegers, (n: Int) => n == 42)
    }

    println {
      Finder.findFirst(listOfStrings, (n: String) => n.startsWith("Rudi"))
    }

    println {
      val who: User => Boolean = _.name == "Rudi"
      Finder.findFirst(listOfUser, who)
    }

    println {
      Finder.isSorted(listOfIntegers.toArray, (a: Int, b: Int) => a <= b)
    }

    println {
      Finder.isSorted(listOfIntegers.toArray.sorted, (a: Int, b: Int) => a <= b)
    }

    println {
      // Removing synthetic sugar.
      val leftSmallerThenRight = new Function2[Int, Int, Boolean] {
        override def apply(a: Int, b: Int): Boolean = a < b
      }

      Finder.isSorted(listOfIntegers.toArray.sorted, leftSmallerThenRight)
    }

    println {
      val sortedBy: (User, User) => Boolean = (a, b) =>
        a.name.length <= b.name.length
      Finder.isSorted(listOfUser.toArray, sortedBy)
    }
  }
}

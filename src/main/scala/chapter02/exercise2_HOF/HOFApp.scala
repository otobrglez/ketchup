package chapter02.exercise2_HOF

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

object HOFApp {

  def main(args: Array[String]): Unit = {
    println("HOFApp")

    val FCurried = HOF.curry((a: Int, b: Int) => a == b)
    val FUnCurried = HOF.uncurry(FCurried)
    
    println {
      FCurried(20)(20)
    }

    println {
      FUnCurried(20, 20)
    }

    println {
      HOF.compose((a: Int) => a + 10, (b: Int) => b * 2)(1)
    }

    // Composing
    val f1: Int => Int = _ + 10
    val f2: Int => Int = _ * 2
    val f3 = f1.compose(f2)

    println(f3(1))
    println(HOF.compose(f1, f2)(1))
  }
}

package chapter01toFP

object ExerciseInRTApp extends App {

  /**
   * Referential transparency
   */

  val name = "Oto"
  println(name.reverse == "otO")
  println("Oto".reverse == "otO")

  /**
   * Non-RT example
   */
  val sb = new StringBuilder("Hello")
  println(sb.append("World") == new StringBuilder("HelloWorld"))
  // append has mutated state outside of expression context - making it non-RT.
  println(sb.append("World") == new StringBuilder("HelloWorld"))
}

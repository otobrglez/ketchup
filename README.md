# 🍅 Ketchup 🍅

Exploration and research around functional programming paradigms in Scala. 
Mostly done by following the famous book Functional programming in Scala.

## Exercises

### Chapter 1
- [CoffeeMachineApp.scala](src/main/scala/chapter01/CoffeeMachineApp.scala) - 
Classical "Coffee Machine" example.
- [CoffeeMachineFPApp.scala](src/main/scala/chapter01toFP/CoffeeMachineFPApp.scala) - 
Rewrite of [CoffeeMachineApp.scala](src/main/scala/chapter01/CoffeeMachineApp.scala) with more FP concepts.
- [ExerciseInRTApp.scala](src/main/scala/chapter01toFP/ExerciseInRTApp.scala) - 
Exercise in [referential transparency (RT)](https://en.wikipedia.org/wiki/Referential_transparency).

### Chapter 2
- [Factorial.scala](src/main/scala/chapter02/Factorial.scala)
- [Fibonacci.scala](src/main/scala/chapter02/Fibonacci.scala) - 
Computing [N-th Fibonacci number](https://www.techiedelight.com/program-to-find-nth-fibonacci-number/) with 
the recursion and [tail-recursion optimization](https://medium.com/@mattmichihara/scala-tail-call-optimization-f853b8f295dc). 
- [Finders.scala [Exercise 2.2]](src/main/scala/chapter02/Finder.scala) - 
Implementation of `findFirst` and `isSorted` with recursion.
- [HOFApp.scala [Exercises 2.3, 2.4 and 2.5]](src/main/scala/chapter02/HOF.scala) - 
Implementation of `curry`, `uncurry` and `compose`; exercises in 
[high-order functions](https://docs.scala-lang.org/tour/higher-order-functions.html) a.k.a HOFs.
- [ExerciseInRTApp.scala](src/main/scala/chapter01toFP/ExerciseInRTApp.scala) - An exercise in referential transparency

### Chapter 3 - Data structures
[List.scala](src/main/scala/chapter03/List.scala) and [ListSpec.scala](src/test/scala/chapter03/ListSpec.scala) 
hold all exercise for chapter 3. Implemented methods are 
`init`, `setHead`, `apply`, `foreach`, `print`, `drop`, `dropWhile`, `filter`, 
`map`, `foldRight`, `foldLeft`, `lenght`, `product`, `append`,...

## Resources
### Books

- [Functional Programming in Scala (Paul Chiusano and Runar Bjarnason)](https://www.manning.com/books/functional-programming-in-scala)

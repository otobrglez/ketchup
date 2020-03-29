# 🍅 Ketchup 🍅

Exploration and research around functional programming paradigms in Scala. 
Mostly done by following the famous book Functional programming in Scala.

## Exercises

### Chapter 1
- [CoffeeMachineApp.scala](src/main/scala/chapter01/CoffeeMachineApp.scala) - 
Classical "Coffee Machine" example.
- [CoffeeMachineFPApp.scala](src/main/scala/chapter01toFP/CoffeeMachineFPApp.scala) - 
Rewrite of CoffeeMachineApp with more FP concepts.
- [ExerciseInRTApp.scala](src/main/scala/chapter01toFP/ExerciseInRTApp.scala) - 
Exercise in [referential transparency (RT)](https://en.wikipedia.org/wiki/Referential_transparency).

### Chapter 2
- [FibonacciApp.scala [Exercise 2.1]](src/main/scala/chapter02/exercise2_1/FibonacciApp.scala) - 
Computing [N-th Fibonacci number](https://www.techiedelight.com/program-to-find-nth-fibonacci-number/) 
with the recursion and [tail-recursion optimization](https://medium.com/@mattmichihara/scala-tail-call-optimization-f853b8f295dc). 
- [FindersApp.scala [Exercise 2.2]](src/main/scala/chapter02/exercise2_2/FindersApp.scala) - 
Implementation of `findFirst` and `isSorted` with recursion.
- [HOFApp.scala [Exercises 2.3, 2.4 and 2.5]](src/main/scala/chapter02/exercise2_HOF/HOFApp.scala) - 
Implementation of `curry`, `uncurry` and `compose`; exercises in [high-order functions](https://docs.scala-lang.org/tour/higher-order-functions.html) a.k.a HOFs.

### Chapter 3
- [SampleApp.scala](src/main/scala/chapter03/datastructures/SampleApp.scala) - 
Custom implementation of `List` (`MList`) with additional functions like `foreach` and `map`.
- [PatternMatchingApp.scala [Exercise 3.1]](src/main/scala/chapter03/exercise3_1/PatternMatchingApp.scala) -
Pattern matching exercise with custom `List` (`MList`).

## Resources
### Books

- Functional Programming in Scala (Paul Chiusano and Runar Bjarnason)
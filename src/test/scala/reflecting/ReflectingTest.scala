package reflecting


object ReflectingTest extends App {
  import Reflecting._

  println(evalMethod(List(5,6,7,8), "head")) //5

  println(evalMethod(List(5,6,7,8), "drop", 2)) //List(7,8)

  println(evalMethod(List(5,6,7,8), "$colon$colon", 2)) //List(2,5,6,7,8)

  println(publicMethods[String])
}

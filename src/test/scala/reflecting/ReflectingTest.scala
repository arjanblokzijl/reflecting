package reflecting


object ReflectingTest extends App {
  import Reflecting._

 println(eval(List(5,6,7,8), "head")) //5

 println(eval(List(5,6,7,8), "drop", 2)) //List(7,8)
}

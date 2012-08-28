package reflecting



object ReflectingTest extends App {
  import Reflecting._

  val l = (1 to 5).toList

  println("head " + evalMethod(l, "head")) //1

  println("drop " + evalMethod(l, "drop", 2)) //List(3,4,5)

  println("map " + evalMethod(l, "map", ((x: Int) => x + 1), Seq.canBuildFrom[Int])) //List(2,3,4,5,6)

  println(":: " + evalMethod(l, "$colon$colon", 6)) //List(6,1,2,3,4,5)

  println(publicMethods[List[_]])
}

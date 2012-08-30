package reflecting

import scala.reflect.runtime.universe._
import scala.reflect.runtime.universe.{build => ub}
import scala.tools.reflect._

object ReflectingTest extends App {
  import Reflecting._

  val l = (1 to 5).toList

  println("head " + evalMethod(l, "head")) //1

  println("drop " + evalMethod(l, "drop", 2)) //List(3,4,5)

  println("map " + evalMethod(l, "map", ((x: Int) => x + 1), Seq.canBuildFrom[Int])) //List(2,3,4,5,6)

  println(":: " + evalMethod(l, "$colon$colon", 6)) //List(6,1,2,3,4,5)

  println(publicMethods[List[_]])

  val e1 = tb.parseExpr("1 to 3 map (_+1)")
  println("e1: "  + tb.runExpr(e1))

  val expr = tb.parseExpr("1 + 2")

  println("raw expr: " + showRaw(expr))

  val onePlusTwo = Apply(Select(Literal(Constant(1)), newTermName("$plus")), List(Literal(Constant(2)))) //same, but building it up explicitly
  println("onePlusTwo: " + tb.runExpr(onePlusTwo)) //3

}

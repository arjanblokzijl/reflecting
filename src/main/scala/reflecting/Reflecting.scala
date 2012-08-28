package reflecting

import scala.reflect.runtime.universe._
import scala.reflect.runtime.{universe => u}
import scala.tools.reflect.ToolBox
import scala.reflect.runtime.{currentMirror => m}
import reflect.ClassTag


object Reflecting {
  val tb = m.mkToolBox()

  val list = List(1,2,3,4,5)

  val il: InstanceMirror = m.reflect(list)

  def eval[T : ClassTag : TypeTag](obj: T, name: String, arg0: Any, args: Any*) = {
    m.reflect(obj).reflectMethod(u.typeOf[T].member(u.newTermName(name)).asMethod).apply((arg0 +: args): _*)
  }

  def eval[T : ClassTag : TypeTag](obj: T, name: String) =
    m.reflect(obj).reflectMethod(u.typeOf[T].member(u.newTermName(name)).asMethod).apply()

}

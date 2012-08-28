package reflecting

import scala.reflect.runtime.universe._
import scala.reflect.runtime.{universe => u}
import scala.tools.reflect.ToolBox
import scala.reflect.runtime.{currentMirror => m}
import reflect.ClassTag


object Reflecting {
  val tb = m.mkToolBox()

  def evalMethod[T : ClassTag : TypeTag](obj: T, name: String, arg0: Any, args: Any*) = {
    m.reflect(obj).reflectMethod(u.typeOf[T].member(u.newTermName(name)).asMethod).apply((arg0 +: args): _*)
  }

  def evalMethod[T : ClassTag : TypeTag](obj: T, name: String) =
    m.reflect(obj).reflectMethod(u.typeOf[T].member(u.newTermName(name)).asMethod).apply()

  def publicMethods[T : TypeTag]: Iterable[(MethodSymbol, Type)] = {
    val tType: Type = u.typeOf[T]
    tType.declarations.sorted.collect {
      case m: MethodSymbol if (m.isPublic && m.isMethod) => m -> m.typeSignatureIn(tType)
    }
  }
}

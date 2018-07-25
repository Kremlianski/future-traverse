import cats.implicits._

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import examples._


val res: List[Int] =  Await.result(list.traverse(performSideEffect), 10.seconds)

println("sideEffect = " + getSideEffect.mkString(", "))
println("result = " + res.mkString(", "))
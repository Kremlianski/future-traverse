import examples._
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

val future = Future.traverse(list) {
    performSideEffect
}

val result = Await.result(future, 12 seconds)

//side effects are not in right order:
println (s"Side Effect: ${getSideEffect.mkString(", ")}")

// but the result is in right order:
println (s"result: ${result.mkString(", ")}")




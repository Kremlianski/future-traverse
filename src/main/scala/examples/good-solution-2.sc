import monix.execution.Scheduler.Implicits.global
import monix.eval.Task
import examples._
import scala.concurrent.duration._


import scala.concurrent.Await


val future = Task.traverse(list) {x =>
  Task.deferFuture(withSideEffect(x))
}.runAsync

val result = Await.result(future, 12 seconds)

//side effects are in right order:
println (s"Side Effect: ${getSideEffect.mkString(", ")}")

// and the result is in right order:
println (s"result: ${result.mkString(", ")}")
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import examples._
import scala.concurrent.ExecutionContext.Implicits.global

def traverse[A, B](values: List[A])
                  (func: A => Future[B]): Future[List[B]] =
  values.foldLeft(Future.successful(List.empty[B])) { (accum, host) =>
    val item = func(host)
    for {
      a <- accum
      i <- item
    } yield (a :+ i)
  }




val result = Await.result(traverse(list)(performSideEffect), 12 seconds)

//side effects are not in right order:
println (s"Side Effect: ${getSideEffect.mkString(", ")}")

// but the result is in right order:
println (s"result: ${result.mkString(", ")}")
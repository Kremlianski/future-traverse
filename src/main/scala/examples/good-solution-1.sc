import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import examples._
import scala.concurrent.ExecutionContext.Implicits.global

def traverse[A, B](values: List[A])
                  (func: A => Future[B]): Future[List[B]] =
  values.foldLeft(Future.successful(List.empty[B])) { (accum, host) =>
    lazy val item = func(host)
    for {
      a <- accum
      i <- item
    } yield (a :+ i)
  }


val result = Await.result(traverse(list)(withSideEffect), 12 seconds)

//side effects are in right order:
println (s"Side Effect: ${getSideEffect.mkString(", ")}")

// and the result is in right order:
println (s"result: ${result.mkString(", ")}")
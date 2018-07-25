import scala.concurrent.Future
import scala.util.Random
import scala.concurrent.ExecutionContext.Implicits.global


package object examples {

  private var sideEffect = List.empty[Int]
  val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9)


  def performSideEffect(n: Int) = Future{
    Thread.sleep(Random.nextInt(100))
    sideEffect :+= n
    n
  }

  def getSideEffect() = sideEffect



}

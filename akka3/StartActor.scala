import akka.actor._
import akka.pattern._
import akka.util._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class HelloActor extends Actor{
  // happy receiver
  def happy: Receive = {
    case "happy" => sender() ! printMessage("Already happy!")
    case _ => context.unbecome
  }

  // original receiver
  def receive = {
    case "Hello" => sender() ! printMessage("World")
    case "happy" => context.become(happy)
    case msg: String => sender() ! printMessage(msg)
  }

  def printMessage(msg: String): String = {
    msg+":"+Thread.currentThread
  }
}

object StartActor {
  def main(args: Array[String]) {
    println("StartActor")
    val system = ActorSystem("system")
    val actor = system.actorOf(Props[HelloActor])
    implicit val timeout = Timeout(5)

    println("Send Message")
    val f: Future[String] = for {
      m1 <- (actor ? "Hello").mapTo[String]
      m2 <- (actor ? "Bye").mapTo[String]
    } yield m1+","+m2
    f.onSuccess {
      case msg: String => println(msg)
    }
    f.onFailure {
      case e => println(e.getMessage)
    }
    system.shutdown
  }
}


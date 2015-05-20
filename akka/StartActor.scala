import akka.actor._

class HelloActor extends Actor{
  // happy receiver
  def happy: Receive = {
    case "happy" => printMessage("Already happy!")
    case _ => context.unbecome
  }

  // original receiver
  def receive = {
    case "Hello" => printMessage("World")
    case "happy" => context.become(happy)
    case msg: String => printMessage(msg)
  }

  def printMessage(msg: String) = {
    println(msg+":"+Thread.currentThread)
  }
}

object StartActor {
  def main(args: Array[String]) {
    println("StartActor")
    val system = ActorSystem("system")
    val actor = system.actorOf(Props[HelloActor])

    println("Send Message")
    // original receiver
    actor ! "Hello"
    // change to happy receiver
    actor ! "happy"
    actor ! "happy"
    // return to original receiver
    actor ! "return"
    actor ! "Bye"
    system.shutdown
  }
}


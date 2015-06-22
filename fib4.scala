object Main {
  lazy val fib: Stream[Long] = Stream.cons(0, Stream.cons(1, fib.zip(fib.tail).map(p => p._1 + p._2)))

  def main(args: Array[String]) {
    println(fib(args(0).toInt))
  }
}

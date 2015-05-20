object fib {
  def main(args: Array[String]) {
    println(fib(args(0).toLong))
  }

  def fib(a: Long): Long = a match {
    case 0 | 1 => a
    case _ => fib(a-2) + fib(a-1)
  }
}

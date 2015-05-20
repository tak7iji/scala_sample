object fib {
  def main(args: Array[String]) {
    println(fib(args(0).toLong))
  }

  def fib(a: Long): Long = {
    def loop(n: Long, n1: Long, m: Long): Long = m match {
       case 0 | 1 => m
       case 2 => n+n1
       case _ =>  loop(n1, n+n1, m-1)
    }
    loop(0, 1, a)
  }
}

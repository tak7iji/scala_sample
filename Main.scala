import fpinscala.datastructures._

object Main {
  def main(args: Array[String]) {
    val ex1: List[Int] = List(1,2,3,4,5)
    val ex2: List[Int] = List(6,7,8,9,10)
    println(List.tail(ex1))
    println(List.setHead(ex1,0))
    println(List.drop(ex1,3))
    println(List.append(ex1,ex2))
  }
}

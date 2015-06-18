import fpinscala.datastructures._

object Main {
  def main(args: Array[String]) {
    val ex1: List[Int] = List(1,2,3,4,5)
    val ex2: List[Int] = List(6,7,8,9,10)
    val ex3: List[Double] = List(1.0, 2.0, 3.0, 4.0, 5.0)
    println(List.tail(ex1))
    println(List.setHead(ex1,0))
    println(List.drop(ex1,3))
    println(List.append(ex1,ex2))
    println(List.init(List.append(ex1,ex2)))
    
    println(List.sum2(ex1))
    println(List.product2(ex3))
    
    println(List.length(ex1))
  }
}

import fpinscala.datastructures._

object Main {
  def main(args: Array[String]) {
    val ex1: List[Int] = List(1,2,3,4,5)
    val ex2: List[Int] = List(6,7,8,9,10)
    val ex3: List[Double] = List(1,2,3,4,5)
    println(List.tail(ex1))
    println(List.setHead(ex1,0))
    println(List.drop(ex1,3))
    println(List.append(ex1,ex2))
    println(List.sum3(ex1))
    println(List.product3(ex3))
    println(List.length2(ex1))

    val ex4: List[Int] = List.range(1,10000)
//    println(List.sum2(ex4))
    println(List.sum3(ex4))
    println(List.append2(ex1,ex2))
    println(List.append3(ex1,ex2))
    println(List.reverse(ex1))

    println(List.addOne(ex1))

    val ex5: List[String] = List("1","2","3","4","5")
    println(List.toDouble(ex5))
  }

}

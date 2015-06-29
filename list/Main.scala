import fpinscala.datastructures._

object Main {
  def main(args: Array[String]) {
    val ex1: List[Int] = List(1,2,3,4,5)
    val ex2: List[Int] = List(6,7,8,9,10)
    val ex3: List[Double] = List(1,2,3,4,5)
    println("tail:"+List.tail(ex1))
    println(List.tail(ex1) == List(2,3,4,5))

    println("setHead:"+List.setHead(ex1,0))
    println(List.setHead(ex1,0) == List(0,2,3,4,5))

    println("drop:"+List.drop(ex1,3))
    println(List.drop(ex1,3) == List(4,5))

    println("append:"+List.append(ex1,ex2))
    println(List.append(ex1,ex2) == List.range(1,11))

    println("sum3:"+List.sum3(ex1))
    println(List.sum3(ex1) == 15)

    println("product3:"+List.product3(ex3))
    println(List.product3(ex3) == 120.0)

    println("length2:"+List.length2(ex1))
    println(List.length2(ex1) == 5)

    val ex4: List[Int] = List.range(1,10000)
//    println(List.sum2(ex4))
    println("sum3:"+List.sum3(ex4))
    println(List.sum3(ex4)==49995000)

    println("append2:"+List.append2(ex1,ex2))
    println(List.append2(ex1,ex2) == List.range(1,11))

    println("append3:"+List.append3(ex1,ex2))
    println(List.append3(ex1,ex2) == List.range(1,11))

    println("reverse:"+List.reverse(ex1))
    println(List.reverse(ex1) == List.range(5,0,-1))

    println("addOne:"+List.addOne(ex1))
    println(List.addOne(ex1) == List.range(2,7))

    println("addOne2:"+List.addOne2(ex1))
    println(List.addOne2(ex1) == List.range(2,7))

    val ex5: List[String] = List("1","2","3","4","5")
    println("toDouble:"+List.toDouble(ex5))
    println(List.toDouble(ex5) == List(1.0,2.0,3.0,4.0,5.0))

    println("toDouble2:"+List.toDouble2(ex5))
    println(List.toDouble2(ex5) == List(1.0,2.0,3.0,4.0,5.0))

    val ex6: List[List[Int]] = List(List(), List(1), List(2), List())
    println("flatMap:"+List.flatMap(ex6)(x=>x))
    println("flatMap:"+List.flatMap(Nil)(x=>x))

    println("filter:"+List.filter(ex1)(x=>x%2!=0))
    println("filter2:"+List.filter2(ex1)(x=>x%2!=0))

    println("zip:"+List.zip(List(1,2,3), List(4,5)))
    println("zip2:"+List.zip2(List(1,2,3), List(4,5)))
    println("zip2:"+List.zip2(List(4,5), List(1,2,3)))
    println("zip3:"+List.zip3(List(1,2,3), List(4,5)))
  }
}

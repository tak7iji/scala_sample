import scala.math._

trait RNG {
  def nextInt: (Int, RNG)
}

case class SimpleRNG(seed: Long) extends RNG {
  def nextInt: (Int, RNG) = {
    val newSeed = (seed * 0x5deece66dl + 0xbl) & 0xffffffffffffffffl
    val nextRNG = SimpleRNG(newSeed)
    val n = (newSeed >>> 16).toInt
      (n, nextRNG)
  }
}

def nonNegativeInt(rng: RNG): (Int, RNG) = {
  val (n, nextRNG) = rng.nextInt
  (n match {
    case Int.MinValue => 0
    case _ => abs(n)
  }, nextRNG)
}

def double(rng: RNG): (Double, RNG) = {
  val (n, nextRNG) = nonNegativeInt(rng)
  val dbl = n / (Int.MaxValue.toDouble + 1)
  (dbl, nextRNG)
}

def ints(count: Int)(rng: RNG): (List[Int], RNG) = {
  def nextInts(c: Int, rng: RNG, ints: List[Int]): (List[Int], RNG) = {
    val (n, nextRNG) = rng.nextInt
    c match {
      case `count` => (ints, rng)
      case _ => nextInts(c+1, nextRNG, ints:+n)
    }
  }
  nextInts(0, rng, List.empty)
}

def ints2(count: Int)(rng: RNG): (List[Int], RNG) = {
  lazy val l:Stream[(Int, RNG)] = Stream.cons(rng.nextInt, l.map(_._2.nextInt))
  val m = l.take(count)
//  (m.map(_._1).toList, m.last._2)
  (m.unzip._1.toList, m.last._2)
}


val rng = SimpleRNG(Long.MinValue / 3)
val nn1 = nonNegativeInt(rng)
println(nn1)
println(nonNegativeInt(nn1._2))
println(double(rng))
println(ints(5)(rng))
println(ints2(5)(rng))

val next = rng.nextInt
println(next)
val next2 = next._2.nextInt
println(next2)
val next3 = next2._2.nextInt
println(next3)
val next4 = next3._2.nextInt
println(next4)
val next5 = next4._2.nextInt
println(next5)


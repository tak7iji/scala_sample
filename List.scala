package fpinscala.datastructures

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A] (head: A, tail: List[A]) extends List[A]

object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A] (as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def tail[A] (l: List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(_, xs) => xs
  }

  def setHead[A] (l: List[A], h: A): List[A] = l match {
    case Nil => Nil
    case Cons(_, xs) => Cons(h, xs)
  }

  def drop[A] (l: List[A], n: Int): List[A] = (n, l) match {
    case (0, l) => l
    case (_, Nil) => Nil
    case _ => drop(tail(l), n-1)
  }

  def append[A] (a1: List[A], a2: List[A]): List[A] = a1 match {
    case Nil => a2
    case Cons(h,t) => Cons(h, append(t, a2))
  }
  
  def init[A] (l: List[A]): List[A] = {
    def func[A] (l1: List[A], l2: List[A]): List[A] = l2 match {
      case Nil => Nil
      case Cons(h, Nil) => l1
      case Cons(h,t) => func(append(l1, Cons(h, Nil)), tail(l2))
    }
    func(Nil, l)
  }
  
  def foldRight[A,B] (as: List[A], z: B)(f: (A,B) => B): B = as match {
    case Nil => z
    case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  }
  
  def sum2(ns: List[Int]) = foldRight(ns, 0)(_ + _)
  
  def product2(ns: List[Double]) = foldRight(ns, 1.0)(_ * _)
  
  def length[A] (as: List[A]): Int = {
    foldRight(as, 0)((x,y) => 1 + y)
  }
}


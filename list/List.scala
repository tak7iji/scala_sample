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

  def range (s: Int, e: Int, i: Int): List[Int] = {
    def create (l: List[Int], m: Int): List[Int] = m match {
      case n if s >= e => Nil
      case o if o+i >= e => append(l, List(o))
      case p => create(append(l, List(p)), p+i)
    }
    create(Nil, s)
  }

  def range (s: Int, e: Int): List[Int] = range(s, e, 1)

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

  def foldLeft[A,B] (as: List[A], z: B)(f: (B,A) => B): B = {
    as match {
      case Nil => z
      case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
    }
  }

  def sum3(ints: List[Int]): Int = foldLeft(ints, 0)(_+_)

  def product3(ds: List[Double]): Double = foldLeft(ds, 1.0)(_*_)

  def length2[A] (as: List[A]): Int = foldLeft(as, 0)((y,x) => 1 + y)

  def append[A] (a1: List[A], a2: List[A]): List[A] = a1 match {
    case Nil => a2
    case Cons(h,t) => Cons(h, append(t, a2))
  }

  def append2[A] (a1: List[A], a2: List[A]): List[A] = foldRight(a1, a2)(Cons(_,_))

  def reverse[A] (as: List[A]): List[A] = {
    foldLeft(as, Nil: List[A])((x,y) => Cons(y,x))
  }

  // a1を逆転させてからやれば良さそう？
  def append3[A] (a1: List[A], a2: List[A]): List[A] = foldLeft(reverse(a1), a2)((x,y) => Cons(y,x))

  def addOne (il: List[Int]): List[Int] = il match {
    case Nil => Nil
    case Cons(i, j) => Cons(i+1, addOne(j))
  }

  def toDouble (sl: List[String]): List[Double] = sl match {
    case Nil => Nil
    case Cons(s, xs) => Cons(s.toDouble, toDouble(xs))
  }

  def map[A,B] (as: List[A])(f: A => B): List[B] = as match {
    case Nil => Nil
    case Cons(x, xs) => Cons(f(x), map(xs)(f))
  }

  def addOne2 (il: List[Int]): List[Int] = map(il)(x => x + 1)
  def toDouble2 (sl: List[String]): List[Double] = map(sl)(x => x.toDouble)

  def flatMap[A,B] (as: List[A])(f: A => List[B]): List[B] = as match {
    case Nil => Nil
    case Cons(x, xs) => append3(f(x), flatMap(xs)(f))
  }

  def filter[A] (as: List[A])(f: A => Boolean): List[A] = as match {
    case Nil => Nil
    case Cons(x, xs) => f(x) match {
      case true => Cons(x, filter(xs)(f))
      case false => filter(xs)(f)
    }
  }

  def filter2[A] (as: List[A])(f: A => Boolean): List[A] = flatMap(as)(x => if(f(x) == true) List(x) else Nil)

  def zip (l1: List[Int], l2: List[Int]): List[Int] = (l1, l2) match {
    case (Nil, _) => Nil
    case (_, Nil) => Nil
    case (Cons(x, xs), Cons(y, ys)) => Cons(x+y, zip(xs, ys))
  }

  def zipWith[A,B] (l1: List[A], l2: List[A])(f: (A, A) => B): List[B] = (l1, l2) match {
    case (Nil, _) => Nil
    case (_, Nil) => Nil
    case (Cons(x, xs), Cons(y, ys)) => Cons(f(x,y), zipWith(xs, ys)(f))
  }

  def zip2 (l1: List[Int], l2: List[Int]): List[Int] = zipWith(l1, l2)(_+_)

  // scala.collection.immutable.List.zip相当
  def zip3 (l1: List[Int], l2: List[Int]): List[(Int,Int)] = zipWith(l1, l2)((_,_))
}


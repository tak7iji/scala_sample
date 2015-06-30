package errorhandling

sealed trait Option[+A] {
  def map[B](f: A => B): Option[B] = this match {
    case None => None
    case Some(v) => Some(f(v))
  }

  def flatMap[B] (f: A => Option[B]): Option[B] = this match {
    case None => None
    case Some(v) => f(v)
  }

  def flatMap2[B] (f: A => Option[B]): Option[B] = this.map(f).getOrElse(None)

  def getOrElse[B >: A] (default: => B): B = this match {
    case None => default
    case Some(v) => v
  }

  def orElse[B >: A] (ob: => Option[B]): Option[B] = {
    if (this != None) this else ob
  }

  def filter(f: A => Boolean): Option[A] = this match {
    case None => None
    case Some(v) => if(f(v) == true) this else None
  }

  def lift[A,B] (f: A => B): Option[A] => Option[B] = _ map f
  def absO: Option[Double] => Option[Double] = lift(math.abs)
}

case class Some[+A](get: A) extends Option[A]
case object None extends Option[Nothing]


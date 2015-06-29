package fpinscala

sealed trait Option[+A] {
  val value: A

  def map[B](f: A => B): Option[B] = this match {
    case None => None
  }
}

case class Some[A](get: A) extends Option[A]
case object None extends Option[Nothing]


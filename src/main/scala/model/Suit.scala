package evolution
package model

trait Suit {
  def id: Int
}

object Suit {
  def apply(id: Int): Suit = id match {
    case 0 => Spades
    case 1 => Diamonds
    case 2 => Clubs
    case 3 => Hearths
    case _ => WrongSuit
  }
}

case object Spades extends Suit {
  val id = 0
}

case object Diamonds extends Suit {
  val id = 1
}

case object Clubs extends Suit {
  val id = 2
}

case object Hearths extends Suit {
  val id = 3
}

case object WrongSuit extends Suit {
  val id = -1
}
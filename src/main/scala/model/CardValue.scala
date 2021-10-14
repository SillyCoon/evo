package evolution
package model

sealed trait CardValue {
  def value: Int
}

case object Ace extends CardValue {
  val value = 12
}

case object King extends CardValue {
  val value = 11
}
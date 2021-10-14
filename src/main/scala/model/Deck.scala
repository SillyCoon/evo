package evolution
package model

import scala.util.Random

object Deck {
  val values: Seq[CardValue] = Seq(Ace, King)
  val suites: Seq[Suit] = Seq(Diamonds, Hearths, Clubs, Spades)
  val cards: Seq[Card] = for {
    value <- values
    suit <- suites
  } yield Card(suit, value)

  def drawCard = cards((new Random()).nextInt(cards.length))
}

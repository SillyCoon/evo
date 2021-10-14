package evolution

import dao.PlayerDaoImpl
import model.Deck
import service.GameService

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Success

object OneCardApp extends App {

  val InitialScore = 1000


  val playerDao = PlayerDaoImpl

  val game = new GameService(playerDao)
  val players = for {
    player1 <- game.registerPlayer(InitialScore)
    player2 <- game.registerPlayer(InitialScore)
  } yield (player1, player2)

  players onComplete {
    case Success((p1, p2)) => println(p1, p2)
    case _ => println("Can't register players")
  }
}

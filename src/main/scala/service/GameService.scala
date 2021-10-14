package evolution
package service

import dao.PlayerDao
import model.Player

import java.util.UUID
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class GameService(dao: PlayerDao) {
  def registerPlayer(initialScore: Int): Future[Player] =
    dao.getAvailableOpponent.flatMap { maybeOpponent =>
      val player = Player(UUID.randomUUID().toString, initialScore, maybeOpponent.map(_.id))
      dao.addPlayer(player).flatMap(_ => maybeOpponent match {
        case Some(opponent) => dao.addOpponent(opponent.id, player.id)
        case _ => Future.successful()
      }).map(_ => player)
    }
}

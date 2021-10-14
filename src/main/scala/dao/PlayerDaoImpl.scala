package evolution
package dao

import model.Player

import scala.concurrent.Future

object PlayerDaoImpl extends PlayerDao {
  private val players = scala.collection.mutable.Map.empty[String, Player]

  override def changeScoreBy(id: String, change: Int): Future[String] = {
    val updated = players.updateWith(id)(maybePlayer => maybePlayer.map(p => p.copy(score = p.score + change)))
    updated match {
      case Some(v) => Future.successful(v.id)
      case _ => Future.failed(new IllegalArgumentException("No such user"))
    }
  }

  override def addPlayer(player: Player): Future[Unit] = {
    players.addOne(player.id, player)
    Future.successful()
  }

  override def addOpponent(playerId: String, opponentId: String): Future[Unit] = {
    players.updateWith(playerId)(_.map(p => p.copy(opponent = Some(opponentId))))
    Future.successful()
  }

  override def getAvailableOpponent: Future[Option[Player]] = Future.successful {
    players.find { case (_, p) => p.opponent.isEmpty }.map(_._2)
  }
}

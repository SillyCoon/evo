package evolution
package dao

import model.Player

import scala.concurrent.Future

trait PlayerDao {
  def changeScoreBy(id: String, change: Int): Future[String]
  def addPlayer(player: Player): Future[Unit]
  def addOpponent(playerId: String, opponentId: String): Future[Unit]
  def getAvailableOpponent: Future[Option[Player]]
}

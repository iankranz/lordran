package tables

import slick.jdbc.PostgresProfile.api._
import slick.lifted.ProvenShape

case class Message(id: Option[Long], text: String)

class MessagesTable(tag: Tag) extends Table[Message](tag, "messages") {
  def id: Rep[Option[Long]] = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
  def text: Rep[String] = column[String]("text")

  def * : ProvenShape[Message] = (id, text).mapTo[Message]
}
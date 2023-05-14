package slick

import slick.jdbc.PostgresProfile.api._
import slick.lifted.ProvenShape

case class Merchant(id: Option[Long], name: String, email: String)

class Merchants(tag: Tag) extends Table[Merchant](tag, "merchants") {
  def id: Rep[Option[Long]] = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
  def name: Rep[String] = column[String]("name")
  def email: Rep[String] = column[String]("email")

  def * : ProvenShape[Merchant] = (id, name, email).mapTo[Merchant]
}
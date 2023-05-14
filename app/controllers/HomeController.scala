package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import slick.jdbc.JdbcBackend.Database
import slick.lifted.TableQuery
import play.api.mvc.{AbstractController, ControllerComponents}
import scala.concurrent.ExecutionContext
import repositories.MessageRepository

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents, messageRepository: MessageRepository)(implicit ec: ExecutionContext) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */

  // def index() = Action { implicit request: Request[AnyContent] =>
    
  //   Ok(views.html.index())
  // }

  def index()() = Action.async {
    messageRepository.list().map { message =>
      Ok(views.html.index(message))
    }
  }
}

package protocols

import play.api.libs.json.{JsValue, Json}


object MessageProtocol {
  case class AddUser(user: UsersData)
  case object GetAllUsers

  case class UsersData(email: String, password: String, comment: Option[String] = None, pLanguage: Option[String] = None, sLanguages: Option[JsValue] = None)

  implicit val getUsersFormat = Json.format[UsersData]
}

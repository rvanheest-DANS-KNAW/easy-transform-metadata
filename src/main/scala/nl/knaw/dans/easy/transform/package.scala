/**
 * Copyright (C) 2019 DANS - Data Archiving and Networked Services (info@dans.knaw.nl)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.knaw.dans.easy

import java.util.UUID

import scalaj.http.HttpResponse

package object transform {

  type BagId = UUID

  object AccessRights extends Enumeration {
    type AccessRights = Value
    val OPEN_ACCESS, OPEN_ACCESS_FOR_REGISTERED_USERS, REQUEST_PERMISSION, NO_ACCESS = Value
  }

  object AccessibleToRights extends Enumeration {
    type AccessibleToRights = Value
    val ANONYMOUS, KNOWN, RESTRICTED_REQUEST, NONE = Value
  }

  val VisibleToRights = AccessibleToRights

  case class HttpStatusException(msg: String, response: HttpResponse[String]) extends Exception(s"$msg - ${ response.statusLine }, details: ${ response.body }")
}

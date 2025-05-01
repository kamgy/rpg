package dev.kamgy
package location

import location.model.LocationModel.*
import org.scalacheck.Gen
import org.scalacheck.Gen.*

object LocationGenerators {
  def locationNameOpt(minLength: Int, maxLength: Int): Gen[Option[LocationName]] =
    Generators.alphaNumStrings(minLength, maxLength).map(LocationName.option.apply)
}

package dev.kamgy
package location.model

import java.util.UUID

import io.github.iltotore.iron.*
import io.github.iltotore.iron.constraint.collection.Empty
import io.github.iltotore.iron.constraint.string.Alphanumeric

object LocationModel {
  type LocationId = LocationId.T

  object LocationId extends RefinedType[UUID, Pure] {
    def generate(): LocationId = LocationId.assume(UUID.randomUUID())
  }

  type LocationName = LocationName.T
  object LocationName extends RefinedType[String, Not[Empty] & Alphanumeric]
}

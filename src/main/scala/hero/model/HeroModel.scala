package dev.kamgy
package hero.model

import java.util.UUID

import io.github.iltotore.iron.*
import io.github.iltotore.iron.constraint.collection.MinLength
import io.github.iltotore.iron.constraint.numeric.Positive
import io.github.iltotore.iron.constraint.string.Alphanumeric

object HeroModel {
  type HeroId = HeroId.T

  object HeroId extends RefinedType[UUID, Pure] {
    def generate(): HeroId = HeroId.applyUnsafe(UUID.randomUUID())
  }

  type HeroName = HeroName.T
  object HeroName extends RefinedType[String, Alphanumeric & MinLength[5]]

  type HeroLevel = HeroLevel.T
  object HeroLevel extends RefinedType[Int, Positive]
}

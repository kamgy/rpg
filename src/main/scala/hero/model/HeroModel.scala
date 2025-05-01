package dev.kamgy
package hero.model

import java.util.UUID

import io.github.iltotore.iron.*
import io.github.iltotore.iron.constraint.collection.{MaxLength, MinLength}
import io.github.iltotore.iron.constraint.numeric.{Positive, Positive0}
import io.github.iltotore.iron.constraint.string.Alphanumeric

object HeroModel {
  type HeroId = HeroId.T

  object HeroId extends RefinedType[UUID, Pure] {
    def generate(): HeroId = HeroId.assume(UUID.randomUUID())
  }

  type HeroName = HeroName.T
  object HeroName extends RefinedType[String, Alphanumeric & MinLength[5] & MaxLength[32]]

  type HeroLevel = HeroLevel.T
  object HeroLevel extends RefinedType[Int, Positive]

  type HeroExperience = HeroExperience.T
  object HeroExperience extends RefinedType[Int, Positive0]
}

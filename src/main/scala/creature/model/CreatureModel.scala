package dev.kamgy
package creature.model

import java.util.UUID

import io.github.iltotore.iron.*
import io.github.iltotore.iron.constraint.collection.Empty
import io.github.iltotore.iron.constraint.numeric.Positive
import io.github.iltotore.iron.constraint.string.Alphanumeric

object CreatureModel {
  type CreatureId = CreatureId.T

  object CreatureId extends RefinedType[UUID, Pure] {
    def generate(): CreatureId = CreatureId.assume(UUID.randomUUID())
  }

  type CreatureName = CreatureName.T
  object CreatureName extends RefinedType[String, Not[Empty] & Alphanumeric]

  type CreatureExperienceReward = CreatureExperienceReward.T
  object CreatureExperienceReward extends RefinedType[Int, Positive]
}

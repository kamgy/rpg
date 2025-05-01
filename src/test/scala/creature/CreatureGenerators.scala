package dev.kamgy
package creature

import creature.model.CreatureModel.*
import org.scalacheck.Gen
import org.scalacheck.Gen.*

object CreatureGenerators {
  def creatureNameOpt(minLength: Int, maxLength: Int): Gen[Option[CreatureName]] =
    Generators.alphaNumStrings(minLength, maxLength).map(CreatureName.option.apply)
  def experienceRewardOpt(min: Int, max: Int): Gen[Option[CreatureExperienceReward]] =
    Gen.choose(min, max).map(CreatureExperienceReward.option.apply)
}

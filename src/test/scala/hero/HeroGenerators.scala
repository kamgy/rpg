package dev.kamgy
package hero

import hero.model.HeroModel.*
import org.scalacheck.*
import org.scalacheck.Gen.*

object HeroGenerators {
  def heroNameOpt(minLength: Int, maxLength: Int): Gen[Option[HeroName]] =
    Generators.alphaNumStrings(minLength, maxLength).map(HeroName.option.apply)
  def heroLevelOpt(minLevel: Int, maxLevel: Int): Gen[Option[HeroLevel]] =
    Gen.choose(minLevel, maxLevel).map(HeroLevel.option.apply)
  def heroExperienceOpt(minExperience: Int, maxExperience: Int): Gen[Option[HeroExperience]] =
    Gen.choose(minExperience, maxExperience).map(HeroExperience.option.apply)
}

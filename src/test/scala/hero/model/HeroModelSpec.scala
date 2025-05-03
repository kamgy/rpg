package dev.kamgy
package hero.model

import hero.HeroGenerators
import hero.model.HeroModel.{HeroExperience, HeroName}
import munit.ScalaCheckSuite
import org.scalacheck.Prop.*

class HeroModelSpec extends ScalaCheckSuite {

  property("HeroName should be invalid with less than 5 characters") {
    forAll(HeroGenerators.heroNameOpt(0, 4)) { heroNameOpt =>
      assert(heroNameOpt.isEmpty)
    }
  }

  property("HeroName should be invalid with more than 32 characters") {
    forAll(HeroGenerators.heroNameOpt(33, 64)) { heroNameOpt =>
      assert(heroNameOpt.isEmpty)
    }
  }

  property("HeroName should be invalid if a valid-length name contains non-alphanumeric characters") {
    forAll(HeroGenerators.heroNameOpt(5, 31), Generators.specialChars) {
      case (Some(validName), specialChar) =>
        val invalidName = validName + specialChar
        assert(HeroName.option(invalidName).isEmpty)
      case _ => fail("Generator produced invalid HeroName unexpectedly")
    }
  }

  property("HeroName should be valid with 5 to 32 characters") {
    forAll(HeroGenerators.heroNameOpt(5, 32)) { heroNameOpt =>
      assert(heroNameOpt.isDefined)
    }
  }

  property("HeroLevel should be invalid below 1") {
    forAll(HeroGenerators.heroLevelOpt(-1000, 0)) { heroLevelOpt =>
      assert(heroLevelOpt.isEmpty)
    }
  }

  property("HeroLevel should be valid for positive values") {
    forAll(HeroGenerators.heroLevelOpt(1, 10000)) { heroLevelOpt =>
      assert(heroLevelOpt.isDefined)
    }
  }

  property("HeroExperience should be invalid below 0") {
    forAll(HeroGenerators.heroExperienceOpt(-1_000_000, -1)) { heroExperienceOpt =>
      assert(heroExperienceOpt.isEmpty)
    }
  }

  test("HeroExperience should be valid for 0") {
    assert(HeroExperience.option(0).isDefined)
  }

  property("HeroExperience should be valid for positive values") {
    forAll(HeroGenerators.heroExperienceOpt(1, 1_000_000)) { heroExperienceOpt =>
      assert(heroExperienceOpt.isDefined)
    }
  }
}

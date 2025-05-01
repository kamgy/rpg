package dev.kamgy
package hero.model

import hero.HeroGenerators
import hero.model.HeroModel.HeroName
import munit.ScalaCheckSuite
import org.scalacheck.Gen
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

  property("HeroName should be invalid when valid name is extended with non-alphanumeric character") {
    forAll(HeroGenerators.heroNameOpt(5, 31), Gen.choose(Char.MinValue, Char.MaxValue).suchThat(!_.isLetterOrDigit)) {
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
}

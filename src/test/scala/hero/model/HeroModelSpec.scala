package dev.kamgy
package hero.model

import hero.HeroGenerators
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

  property("HeroName should be valid with 5 to 32 characters") {
    forAll(HeroGenerators.heroNameOpt(5, 32)) { heroNameOpt =>
      assert(heroNameOpt.isDefined)
    }
  }

  property("HeroLevel should be invalid below 1") {
    forAll(HeroGenerators.heroLevelOpt(Int.MinValue, 0)) { heroLevelOpt =>
      assert(heroLevelOpt.isEmpty)
    }
  }

  property("HeroLevel should be valid for positive values") {
    forAll(HeroGenerators.heroLevelOpt(1, Int.MaxValue)) { heroLevelOpt =>
      assert(heroLevelOpt.isDefined)
    }
  }

  property("HeroExperience should be invalid below 0") {
    forAll(HeroGenerators.heroExperienceOpt(Int.MinValue, -1)) { heroExperienceOpt =>
      assert(heroExperienceOpt.isEmpty)
    }
  }

  property("HeroExperience should be valid for positive values") {
    forAll(HeroGenerators.heroExperienceOpt(1, Int.MaxValue)) { heroExperienceOpt =>
      assert(heroExperienceOpt.isDefined)
    }
  }
}

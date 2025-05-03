package dev.kamgy
package creature.model

import creature.CreatureGenerators
import dev.kamgy.creature.model.CreatureModel.CreatureName
import munit.ScalaCheckSuite
import org.scalacheck.Gen
import org.scalacheck.Prop.*

class CreatureModelSpec extends ScalaCheckSuite {

  test("CreatureName should be invalid when empty") {
    CreatureName.option("").isEmpty
  }

  property("CreatureName should be invalid when it contains non-alphanumeric character") {
    forAll(CreatureGenerators.creatureNameOpt(1, 128), Generators.specialChars) {
      case (Some(validName), specialChar) =>
        val invalidName = validName + specialChar
        assert(CreatureName.option(invalidName).isEmpty)
      case _ => fail("Generator produced invalid CreatureName unexpectedly")
    }
  }

  property("CreatureName should be valid for non-empty alphanumeric") {
    forAll(CreatureGenerators.creatureNameOpt(1, 128)) { creatureNameOpt =>
      assert(creatureNameOpt.isDefined)
    }
  }

  property("CreatureExperienceReward should be invalid below 1") {
    forAll(CreatureGenerators.experienceRewardOpt(-100, 0)) { rewardOpt =>
      assert(rewardOpt.isEmpty)
    }
  }

  property("CreatureExperienceReward should be valid for positive values") {
    forAll(CreatureGenerators.experienceRewardOpt(1, 1_000_000)) { rewardOpt =>
      assert(rewardOpt.isDefined)
    }
  }
}

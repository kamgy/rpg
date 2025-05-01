package dev.kamgy
package location.model

import dev.kamgy.location.model.LocationModel.LocationName
import location.LocationGenerators
import munit.ScalaCheckSuite
import org.scalacheck.Prop.*

class LocationModelSpec extends ScalaCheckSuite {

  test("LocationName should be invalid when empty") {
    assert(LocationName.option("").isEmpty)
  }

  property("LocationName should be valid for non-empty alphanumeric strings") {
    forAll(LocationGenerators.locationNameOpt(1, 256)) { nameOpt =>
      assert(nameOpt.isDefined)
    }
  }
}

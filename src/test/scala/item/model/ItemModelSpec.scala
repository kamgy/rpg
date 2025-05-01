package dev.kamgy
package item.model

import dev.kamgy.item.model.ItemModel.ItemName
import item.ItemGenerators
import munit.ScalaCheckSuite
import org.scalacheck.Prop.*

class ItemModelSpec extends ScalaCheckSuite {

  test("ItemName should be invalid when empty") {
    assert(ItemModel.ItemName.option("").isEmpty)
  }

  property("ItemName should be invalid when it contains non-alphanumeric character") {
    forAll(ItemGenerators.itemNameOpt(1, 255), Generators.specialChars) {
      case (Some(validName), specialChar) =>
        val invalidName = validName + specialChar
        assert(ItemName.option(invalidName).isEmpty)
      case _ => fail("Generator produced invalid ItemName unexpectedly")
    }
  }

  property("ItemName should be valid for non-empty alphanumeric strings") {
    forAll(ItemGenerators.itemNameOpt(1, 256)) { itemNameOpt =>
      assert(itemNameOpt.isDefined)
    }
  }

  property("ItemPrice should be invalid below 1") {
    forAll(ItemGenerators.itemPriceOpt(-1000, 0)) { priceOpt =>
      assert(priceOpt.isEmpty)
    }
  }

  property("ItemPrice should be valid for positive values") {
    forAll(ItemGenerators.itemPriceOpt(1, 1_000_000)) { priceOpt =>
      assert(priceOpt.isDefined)
    }
  }
}

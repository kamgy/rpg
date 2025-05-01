package dev.kamgy
package item

import item.model.ItemModel.*
import org.scalacheck.Gen

object ItemGenerators {
  def itemNameOpt(minLength: Int, maxLength: Int): Gen[Option[ItemName]] =
    Generators.alphaNumStrings(minLength, maxLength).map(ItemName.option.apply)

  def itemPriceOpt(minPrice: Int, maxPrice: Int): Gen[Option[ItemPrice]] =
    Gen.choose(minPrice, maxPrice).map(ItemPrice.option.apply)
}

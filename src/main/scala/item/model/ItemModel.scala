package dev.kamgy
package item.model

import java.util.UUID

import io.github.iltotore.iron.*
import io.github.iltotore.iron.constraint.collection.Empty
import io.github.iltotore.iron.constraint.numeric.Positive
import io.github.iltotore.iron.constraint.string.Alphanumeric

object ItemModel {
  type ItemId = ItemId.T

  object ItemId extends RefinedType[UUID, Pure] {
    def generate(): ItemId = ItemId.assume(UUID.randomUUID())
  }

  type ItemName = ItemName.T
  object ItemName extends RefinedType[String, Not[Empty] & Alphanumeric]

  type ItemPrice = ItemPrice.T
  object ItemPrice extends RefinedType[Int, Positive]
}

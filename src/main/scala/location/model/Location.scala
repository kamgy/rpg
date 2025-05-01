package dev.kamgy
package location.model

import location.model.Location.*
import location.model.LocationModel.{LocationId, LocationName}

case class Location(
  id: LocationId,
  name: LocationName
)

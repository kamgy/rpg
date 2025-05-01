package dev.kamgy
package item.model

import hero.model.HeroModel.*

case class Item(
  id: HeroId,
  name: HeroName,
  level: HeroLevel,
  experience: HeroExperience
)

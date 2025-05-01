package dev.kamgy
package hero.model

import hero.model.HeroModel.*

case class Hero(
  id: HeroId,
  name: HeroName,
  level: HeroLevel,
  experience: HeroExperience
)

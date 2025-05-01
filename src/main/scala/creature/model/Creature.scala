package dev.kamgy
package creature.model

import creature.model.CreatureModel.*

case class Creature(
  id: CreatureId,
  name: CreatureName,
  experienceReward: CreatureExperienceReward
)

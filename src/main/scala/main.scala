package dev.kamgy

import hero.model.Hero
import hero.model.HeroModel.*

@main
def main(): Unit =
  val hero = Hero(HeroId.generate(), HeroName("SuperHero"), HeroLevel(1))
  println(hero)

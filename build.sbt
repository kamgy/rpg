ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.6.4"

lazy val dependencies = {
  Dependencies.test :+
    Dependencies.iron
}

lazy val root = (project in file("."))
  .settings(
    name             := "rpg",
    idePackagePrefix := Some("dev.kamgy"),
    libraryDependencies ++= dependencies
  )

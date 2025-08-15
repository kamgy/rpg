import sbt.*

object Dependencies {
  private object Version {
    val catsEffect      = "3.6.3"
    val iron            = "3.0.0"
    val munit           = "1.1.1"
    val munitScalaCheck = "1.1.0"
  }

  lazy val cats: ModuleID = "org.typelevel" %% "cats-effect" % Version.catsEffect

  lazy val iron: ModuleID = "io.github.iltotore" %% "iron" % Version.iron

  lazy val test: Seq[ModuleID] = {
    Seq("org.scalameta" %% "munit" % Version.munit, "org.scalameta" %% "munit-scalacheck" % Version.munitScalaCheck)
      .map(_ % "test")
  }
}

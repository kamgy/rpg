import sbt.*

object Dependencies {
  private object Version {
    val iron            = "3.0.0"
    val munit           = "1.1.1"
    val munitScalaCheck = "1.1.0"
  }

  lazy val iron: ModuleID = "io.github.iltotore" %% "iron" % Version.iron

  lazy val test: Seq[ModuleID] = {
    Seq("org.scalameta" %% "munit" % Version.munit, "org.scalameta" %% "munit-scalacheck" % Version.munitScalaCheck)
      .map(_ % "test")
  }
}

import sbt.*

object Dependencies {
  private object Version {
    val iron = "3.0.0"
  }

  lazy val iron: ModuleID = "io.github.iltotore" %% "iron" % Version.iron
}

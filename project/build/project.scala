import sbt._

class Giter8Template(info: ProjectInfo)
    extends DefaultProject(info) with giter8.Template {
  override def disableCrossPaths = true
}

// vim: set ts=4 sw=4 et:

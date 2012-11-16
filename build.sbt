//configure sbt to compile with this version
scalaVersion := "2.10.0-RC2"

scalaBinaryVersion <<= scalaVersion.identity

//visualize the dependency graph
net.virtualvoid.sbt.graph.Plugin.graphSettings

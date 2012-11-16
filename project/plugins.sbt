// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository 
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

// Blend credz
credentials += Credentials("Artifactory Realm", "blend.artifactoryonline.com", "deployer", System.getProperty("BLEND_ARTEFACTORY"))

// Blend repository
resolvers += "Blend Repository" at "https://blend.artifactoryonline.com/blend/blend"

// Blend ivy repo
resolvers += Resolver.url("blend-ivy", url("http://blend.artifactoryonline.com/blend/blend-ivy"))(Resolver.ivyStylePatterns)

// Use the Play sbt plugin for Play projects
//addSbtPlugin("play" % "sbt-plugin" % Option(System.getProperty("play.version")).getOrElse("2.1-10112012"))
addSbtPlugin("play" % "sbt-plugin" % "2.1-11022012")

//dep graph
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.0")

//elipse
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.1.0")

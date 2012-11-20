import sbt._
import Keys._
import play.Project._

/*
 * if you want to cross-build: https://github.com/harrah/xsbt/wiki/Cross-Build
 * As of now, json4s is missing json4s-ast, so jam that lib in here
 */
object ApplicationBuild extends Build {

  val appName         = "$application_name$"
  val appVersion      = "0.1"
  
  /*
   * Specify dependencies for project (not for the build)
   * note,           "com.foo" %% "bar" % "1.0" 
   * is shorthad for "com.foo" % "bar-2.10.0-RC1" % "1.0"
   */
  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm,
    // Json4s is a good JSON for 2.10, but use RC1 for now coz RC2 has bad pom
    // Check bad pom @ http://repo.typesafe.com/typesafe/simple/snapshots/org/json4s/
    // "org.json4s" %% "json4s-jackson" % "3.1.0-SNAPSHOT"
    "org.json4s" % "json4s-jackson_2.10.0-RC1" % "3.1.0-SNAPSHOT"
  )

  val appResolvers = Seq(
      //Typesafe
      "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
      "Typesafe Snapshot Repository" at "http://repo.typesafe.com/typesafe/simple/snapshots/",
      //Maven
      //"Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository",
      //"java-net" at "http://download.java.net/maven/2",
      //Ivy
      Resolver.file("Local Ivy", file(Path.userHome + "/.ivy2/local"))(Resolver.ivyStylePatterns)
      //Sonatype
      //"sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases",
      //"sonatype-snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
      //reactivemongo
      //"sgodbillon" at "https://bitbucket.org/sgodbillon/repository/raw/master/snapshots/"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
    resolvers ++= appResolvers
  )

}

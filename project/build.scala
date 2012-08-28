import sbt._
import Keys._


object ReflectBuild extends Build {

  lazy val root = Project(
    id = "reflecting",
    base = file("."),
    settings = standardSettings    
  )

  lazy val standardSettings = Defaults.defaultSettings ++ Seq(
    organization := "com.github.ab",
    version := "0.1-SNAPSHOT",
    scalaVersion := "2.10.0-M7",
    crossPaths := false,
    scalacOptions  ++= Seq("-encoding", "UTF-8", "-deprecation", "-unchecked"),
    resolvers ++= Seq("releases" at "http://oss.sonatype.org/content/repositories/releases",
                        "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots"),
    libraryDependencies <+= (scalaVersion)("org.scala-lang" % "scala-compiler" % _),
    libraryDependencies <+= (scalaVersion)("org.scala-lang" % "scala-reflect" % _)
  )
}

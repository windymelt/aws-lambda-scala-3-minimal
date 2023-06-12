val scala3Version = "3.3.0"
val circeVersion = "0.14.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "aws-lambda-scala-3-minimal",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "com.amazonaws" % "aws-lambda-java-core" % "1.2.2",
      "org.apache.logging.log4j" % "log4j-api" % "2.20.0",
      "org.apache.logging.log4j" % "log4j-to-slf4j" % "2.20.0",
      "org.slf4j" % "slf4j-api" % "2.0.7",
      "io.microlam" % "slf4j-simple-lambda" % "2.0.3_1"
    ),
    libraryDependencies ++= Seq(
      "io.circe" %% "circe-core",
      "io.circe" %% "circe-generic",
      "io.circe" %% "circe-parser"
    ).map(_ % circeVersion)
  )

// Merging artifact files among multiple JARs.
// Because log4j gets easily broken by rough merging
ThisBuild / assemblyMergeStrategy := {
  case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
  case x                                   => MergeStrategy.first
}

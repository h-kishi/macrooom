name := "macrooom"

version := "0.1.0"

scalaVersion := "2.12.0"

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-compiler" % scalaVersion.value,
  "org.scala-lang" % "scala-reflect" % scalaVersion.value,
  "org.specs2" %% "specs2-core" % "3.8.6" % "test"
)

scalacOptions in Test ++= Seq("-Yrangepos")
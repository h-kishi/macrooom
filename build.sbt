import SonatypeKeys._

sonatypeSettings

name := "Macrooom"

version := "0.1.0"

scalaVersion := "2.12.0"

crossScalaVersions := Seq(
  "2.11.8",
  "2.12.0"
)

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-compiler" % scalaVersion.value,
  "org.scala-lang" % "scala-reflect" % scalaVersion.value,
  "org.specs2" %% "specs2-core" % "3.8.6" % "test"
)

scalacOptions in Test ++= Seq("-Yrangepos")

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

organization := "com.github.h-kishi"

organizationHomepage := Some(url("https://github.com/h-kishi"))

description := "Scala macro-based object-object mapper"

pomExtra :=
  <url>https://github.com/h-kishi/macrooom</url>
  <licenses>
    <license>
      <name>MIT</name>
      <url>https://github.com/h-kishi/macrooom/blob/master/LICENSE</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:h-kishi/macrooom.git</url>
    <connection>scm:git:git@github.com:h-kishi/macrooom.git</connection>
  </scm>
  <developers>
    <developer>
      <id>h_kishi</id>
      <name>Hiromichi Kishi</name>
      <url>https://github.com/h-kishi</url>
    </developer>
  </developers>



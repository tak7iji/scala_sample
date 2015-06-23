import JmhKeys._

name := "jhm-scala-example"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.1"

organization := "org.littlewings"

incOptions := incOptions.value.withNameHashing(true)

val jmhVersion = "0.9.2"

libraryDependencies += "org.openjdk.jmh" % "jmh-core" % jmhVersion

jmhSettings

version in Jmh := jmhVersion

outputTarget in Jmh := target.value / s"scala-${scalaBinaryVersion.value}"

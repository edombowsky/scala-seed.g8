ThisBuild / organization := "$organization;format="lower,package"$"
ThisBuild / scalaVersion := "2.12.8"
ThisBuild / version := "0.0.1-SNAPSHOT"

lazy val `$name;format="norm"$` =
  project
    .in(file("."))
    .settings(
      name := "$name$",
      addCompilerPlugin(Dependencies.CompilerPlugins.`kind-projector`),
      libraryDependencies ++= Seq(
        Dependencies.Test.`scalacheck-shapeless_1.14` % Test,
        Dependencies.Test.scalacheck % Test,
        Dependencies.Test.scalatest % Test
      )
    )

ThisBuild / scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-language:_",
  "-Ypartial-unification", // Enabled by default since Scala 2.13.0
  "-Ywarn-unused:_", // -Wunused in Scala 2.13.x
  "-Xfatal-warnings"
)

ThisBuild / console / scalacOptions --= Seq(
  "-Ywarn-unused:_", // -Wunused in Scala 2.13.x
  "-Xfatal-warnings"
)

lazy val cctt: String =
  "compile->compile;test->test"
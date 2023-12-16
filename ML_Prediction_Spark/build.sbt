

name := """sparkSum"""

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

resolvers += "Akka library repository".at("https://repo.akka.io/maven")

val akkaVersion = "2.9.0"
val akkaHttpVersion = "10.6.0"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "org.apache.spark" %% "spark-core" % "3.5.0",
  "org.apache.spark" %% "spark-sql" % "3.5.0",
  "org.apache.spark" %% "spark-mllib" % "3.5.0",
  "com.github.tototoshi" %% "scala-csv" % "1.3.10",
  "org.scalatest" %% "scalatest" % "3.2.10" % "test"
)



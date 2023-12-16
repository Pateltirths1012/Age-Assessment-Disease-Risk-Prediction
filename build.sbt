import org.scalajs.linker.interface.ModuleSplitStyle

lazy val sparkSum = project in file("sparkSum")

lazy val root = project.in(file("."))
  .aggregate(sparkSum)
  .enablePlugins(ScalaJSPlugin) // Enable the Scala.js plugin in this project
  .settings(
    scalaVersion := "3.2.2",
    name := "AgeAssessmentDiseaseRiskPrediction",

    // Tell Scala.js that this is an application with a main method
    scalaJSUseMainModuleInitializer := true,

    /* Configure Scala.js to emit modules in the optimal way to
     * connect to Vite's incremental reload.
     * - emit ECMAScript modules
     * - emit as many small modules as possible for classes in the "livechart" package
     * - emit as few (large) modules as possible for all other classes
     *   (in particular, for the standard library)
     */
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(
          ModuleSplitStyle.SmallModulesFor(List("AgeAssessmentDiseaseRiskPrediction")))
    },


    /* Depend on the scalajs-dom library.
     * It provides static types for the browser DOM APIs.
     */
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.4.0",

    //depend on laminar
    libraryDependencies += "com.raquo" %%% "laminar" % "15.0.1",

    // Testing framework
    libraryDependencies += "org.scalameta" %%% "munit" % "0.7.29" % Test,

      //using type checking lib for scala 2.13 instead of scala 3 for akka compatibility
      libraryDependencies += ("org.typelevel" %% "cats-core" % "2.9.0").cross(CrossVersion.for3Use2_13)
  )



val akkaVersion = "2.8.0"
val akkaHttpVersion = "10.5.0"

libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion
)

libraryDependencies += "me.shadaj" %%% "slinky-core" % "0.7.0" // core React functionality, no React DOM
libraryDependencies += "me.shadaj" %%% "slinky-web" % "0.7.0" // React DOM, HTML and SVG tags
//libraryDependencies += "me.shadaj" %%% "slinky-native" % "0.7.0" // React Native components
libraryDependencies += "me.shadaj" %%% "slinky-hot" % "0.7.0" // Hot loading, requires react-proxy package
libraryDependencies += "me.shadaj" %%% "slinky-scalajsreact-interop" % "0.7.0" // Interop with japgolly/scalajs-react






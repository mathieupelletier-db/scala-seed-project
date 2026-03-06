scalaVersion := "2.13.16"
libraryDependencies += "com.databricks" %% "databricks-connect" % "17.0.1"
// other dependencies go here...

// to run with new jvm options, a fork is required otherwise it uses same options as sbt process
fork := true
javaOptions += "--add-opens=java.base/java.nio=ALL-UNNAMED"

assembly / assemblyMergeStrategy := {
  case PathList("META-INF", "FastDoubleParser-NOTICE")                                  => MergeStrategy.first
  case "scala-collection-compat.properties"                                              => MergeStrategy.first
  case "Log4j-charsets.properties"                                                       => MergeStrategy.first
  case PathList("META-INF", "org", "apache", "logging", "log4j", "core", "config", "plugins", "Log4j2Plugins.dat") =>
    MergeStrategy.first
  case x if x.endsWith("/module-info.class")                                              => MergeStrategy.discard
  case x                                                                                 => (assembly / assemblyMergeStrategy).value(x)
}


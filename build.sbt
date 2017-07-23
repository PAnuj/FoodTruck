name := """play-java"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  "mysql" % "mysql-connector-java" % "5.1.21",
  "javax.activation" % "activation" % "1.1.1",
  "javax.mail" % "mail" % "1.4.1",
   "com.fasterxml.jackson.dataformat" % "jackson-dataformat-xml" % "2.7.2"
) 

libraryDependencies += javaWs
libraryDependencies += "org.eclipse.persistence" % "eclipselink" % "2.5.0"
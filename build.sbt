name := "Autometeus"

version := "0.1"

scalaVersion := "2.9.1"

libraryDependencies += "junit" % "junit" % "4.9" % "test"

libraryDependencies += "org.scalatest" %% "scalatest" % "1.7.2" % "test"

libraryDependencies += "org.scalaz" %% "scalaz-core" % "6.0.4"

libraryDependencies += "com.codahale" % "jerkson_2.9.1" % "0.5.0"

resolvers ++= Seq("Codahale" at "http://repo.codahale.com")

libraryDependencies ++= Seq("com.codahale" %% "jerkson" % "0.5.0")

/* add project library ('groupId % artifactId % version' seperated by comma) */
libraryDependencies ++= Seq()

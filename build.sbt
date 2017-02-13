name := "rabbit-example-1"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.1.1",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "org.suecarter" %% "freeslick" % "3.1.1.0" withSources(),
  "com.typesafe.slick" %% "slick-hikaricp" % "3.1.0",
  "com.typesafe.akka" %% "akka-http" % "10.0.0",
  "com.typesafe.akka" %% "akka-http-testkit" % "10.0.0",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.0",
  "com.typesafe.akka" %% "akka-http-jackson" % "10.0.0",
  "com.typesafe.akka" %% "akka-http-xml" % "10.0.0",
  "org.scalaz" %% "scalaz-core" % "7.1.0",
  "com.chuusai" %% "shapeless"  % "2.0.0" withSources(),
  "org.scalatest"  %% "scalatest" % "2.2.1" % "test",
  "com.thenewmotion" %% "akka-rabbitmq" % "3.0.0"
)
    
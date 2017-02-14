name := "rabbit-example-1"

version := "1.0"

scalaVersion := "2.11.8"

resolvers ++= Seq(
  "SpinGo OSS" at "http://spingo-oss.s3.amazonaws.com/repositories/releases"
)

val opRabbitVersion = "1.6.0"


libraryDependencies ++= Seq(
  "com.spingo" %% "op-rabbit-core"        % opRabbitVersion,
  "com.spingo" %% "op-rabbit-play-json"   % opRabbitVersion,
  "com.spingo" %% "op-rabbit-json4s"      % opRabbitVersion,
  "com.spingo" %% "op-rabbit-airbrake"    % opRabbitVersion,
  "com.spingo" %% "op-rabbit-akka-stream" % opRabbitVersion,
  "com.chuusai" %% "shapeless"  % "2.0.0" withSources(),
  "com.typesafe.akka" %% "akka-http" % "10.0.0",
  "com.typesafe.akka" %% "akka-http-testkit" % "10.0.0",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.0",
  "com.typesafe.akka" %% "akka-http-jackson" % "10.0.0",
  "com.typesafe.akka" %% "akka-http-xml" % "10.0.0",
  "com.chuusai" %% "shapeless"  % "2.0.0" withSources(),
  "org.scalatest"  %% "scalatest" % "2.2.1" % "test",
  "org.slf4j" % "slf4j-api" % "1.7.21"

)
    
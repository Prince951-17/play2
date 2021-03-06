
name := "web-lessons-tuit"

includeFilter in (Assets, LessKeys.less) := "*.less"
excludeFilter in (Assets, LessKeys.less) := "_*.less"

 
version := "1.0"
val akkaV = "2.5.8"
      
lazy val `play2` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"
      
scalaVersion := "2.12.2"

val akkaLibs = Seq(
  "com.typesafe.akka" %% "akka-contrib" % akkaV,
  "com.typesafe.akka" %% "akka-actor" % akkaV,
  "com.typesafe.akka" %% "akka-persistence" % akkaV,
  "com.typesafe.akka" %% "akka-remote" % akkaV,
  "com.typesafe.akka" %% "akka-testkit" % akkaV,
  "com.github.romix.akka" % "akka-kryo-serialization_2.12" % "0.5.2"
)

val akkaHttp = Seq(
  "com.typesafe.akka" %% "akka-http" % "10.0.10",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.10"
)

val pgSqlDriver = "org.postgresql" % "postgresql" % "42.0.0"

val dbLibs = Seq(
  "com.typesafe.slick" %% "slick" % "3.2.1",
  "com.github.tminglei" %% "slick-pg" % "0.15.1",
  "com.github.tminglei" %% "slick-pg_play-json" % "0.15.1",
  "com.h2database" % "h2" % "1.4.194",
  "com.opentable.components" % "otj-pg-embedded" % "0.10.0",
  pgSqlDriver
)

val commonDependencies = Seq(
  "com.typesafe.play" %% "play-json" % "2.6.8",
  "com.typesafe.play" %% "play-slick" % "3.0.3",
  "com.typesafe.play" %% "play-slick-evolutions" % "3.0.3",
  "org.joda" % "joda-convert" % "1.8.1"
)

libraryDependencies ++= akkaLibs ++ akkaHttp ++ commonDependencies ++ dbLibs ++ Seq(ws , specs2 % Test , guice ,
  "com.typesafe.scala-logging" % "scala-logging_2.12" % "3.7.2",
  "ch.qos.logback" % "logback-classic" % "1.1.7",
  "ch.qos.logback" % "logback-core" % "1.1.7",
  "org.slf4j" % "log4j-over-slf4j" % "1.7.21",
  "org.codehaus.janino" % "janino" % "3.0.7",
  //web jars
  "org.webjars" %% "webjars-play" % "2.6.1",
  "org.webjars" % "jquery" % "1.11.3",
  "org.webjars" % "knockout" % "3.3.0",
  "org.webjars" % "requirejs" % "2.2.0",
  "org.webjars" % "bootstrap" % "3.3.4",
  "org.webjars" % "momentjs" % "2.8.1"

)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

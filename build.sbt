name := "sql-over-ssh-tunnel"

version := "1.0-SNAPSHOT"

organization := "com.charandeepmatta"

scalaVersion := "2.9.2"

resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"

libraryDependencies ++= Seq(
                            "com.jcraft" % "jsch" % "0.1.48",
                            "org.springframework" % "spring-jdbc" % "3.1.2.RELEASE",
                            "org.springframework" % "spring-beans" % "3.1.2.RELEASE",
                            "org.springframework" % "spring-core" % "3.1.2.RELEASE",
                            "org.springframework" % "spring-asm" % "3.1.2.RELEASE",
                            "org.springframework" % "spring-tx" % "3.1.2.RELEASE",
                            "org.springframework" % "spring-aop" % "3.1.2.RELEASE",
                            "org.springframework" % "spring-context" % "3.1.2.RELEASE",
                            "org.springframework" % "spring-expression" % "3.1.2.RELEASE"
                           )

scalacOptions += "-deprecation"

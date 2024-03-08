# docker-maven-sample
This is a sample that explains how we can build & package a maven project using Docker Containers.

Container used for built: maven:3.6.0-jdk-11-slim

Container used for packaging (executable): openjdk:11-jre-slim

## Generate sample maven project
Using spring initializer to generate a demo app https://start.spring.io/

## Create a multi-stage build Dockerfile

```shell
#
# BUILD STAGE
#
FROM maven:3.6.0-jdk-11-slim AS build  
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml clean package

#
# PACKAGE STAGE
#
FROM openjdk:11-jre-slim 
COPY --from=build /usr/src/app/target/demo-0.0.1-SNAPSHOT.jar /usr/app/demo-0.0.1-SNAPSHOT.jar  
EXPOSE 8080  
CMD ["java","-jar","/usr/app/demo-0.0.1-SNAPSHOT.jar"]  
```

## Building of the image

```shell
docker build -t demo:latest .
```

## Run the image

```shell
docker run --rm -it demo:latest
```

Expected result
```shell

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.4.RELEASE)

2020-02-04 06:49:04.343  INFO 1 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplicatio
n v0.0.1-SNAPSHOT on 862a2417022a with PID 1 (/usr/app/demo-0.0.1-SNAPSHOT.jar started by root in /)
2020-02-04 06:49:04.350  INFO 1 --- [           main] com.example.demo.DemoApplication         : No active profile set,
falling back to default profiles: default
2020-02-04 06:49:04.913  INFO 1 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication
 in 1.085 seconds (JVM running for 1.589)
```

## Misc

Maven can be optimized to use local/remote repository to cache artifacts. https://hub.docker.com/_/maven

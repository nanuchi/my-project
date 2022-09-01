FROM openjdk:8-jre-alpine

EXPOSE 8080

COPY /home/runner/work/my-project/my-project/build/libs/java-app-1.0-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "my-app-1.0-SNAPSHOT.jar"]

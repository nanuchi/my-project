FROM openjdk:8-jre-alpine

EXPOSE 8080

COPY ./build/libs/test-app-1.0-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "test-app-1.0-SNAPSHOT.jar"]

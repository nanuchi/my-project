FROM openjdk:8-jre-alpine

EXPOSE 8080

COPY ./build/libs/hello-rest-service-0.1.0.jar /usr/app/
WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "hello-rest-service-0.1.0.jar"]

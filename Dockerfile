FROM openjdk:8-jre-alpine

EXPOSE 8080

COPY /home/demousr/actions-runner/_work/java-gradle-project/java-gradle-project/build/libs/java-app-1.0-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "java-app-1.0-SNAPSHOT.jar"]

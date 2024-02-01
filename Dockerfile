FROM openjdk:8-jre-alpine

EXPOSE 8080

COPY ./README.md /usr/app/
WORKDIR /usr/app

ENTRYPOINT ["java", "--version"]

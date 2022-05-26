# FROM openjdk:8-jre-alpine

# EXPOSE 8080

# COPY ./build/libs/my-app-1.0-SNAPSHOT.jar /usr/app/
# WORKDIR /usr/app

# ENTRYPOINT ["java", "-jar", "my-app-1.0-SNAPSHOT.jar"]

# Base image
FROM alpine:latest

# installes required packages for our script
RUN apk add --no-cache \
  bash \
  ca-certificates \
  curl \
  jq

# Copies your code file  repository to the filesystem
COPY entrypoint.sh /entrypoint.sh

# change permission to execute the script and
RUN chmod +x /entrypoint.sh

# file to execute when the docker container starts up
ENTRYPOINT ["/entrypoint.sh"]

FROM openjdk:17-jdk-slim as build
LABEL maintainer="mtopgul" version="1.0" name="client-app"
WORKDIR /app
COPY target/client.jar client.jar
ENTRYPOINT ["java","-jar","client.jar"]
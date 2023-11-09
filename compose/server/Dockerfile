FROM openjdk:17-jdk-slim as build
LABEL maintainer="mtopgul" version="1.0" name="server-app"
WORKDIR /app
COPY target/server.jar server.jar
ENTRYPOINT ["java","-jar","server.jar"]
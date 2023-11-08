##Start with a base image containing Java runtime
#FROM openjdk:17-jdk-slim as build

FROM ubuntu:18.04

# Ubuntu'yu güncelle
RUN apt-get update -y

# Java'yı indir
RUN apt-get install default-jdk -y

# Add labels
LABEL maintainer="mtopgul" version="1.0" name="java-docker"

# cd to app directory
WORKDIR /app

# Copy Java file
COPY Hello.java .

# Compile Java
RUN javac Hello.java

#CMD ["java", "Hello"]
ENTRYPOINT ["java", "Hello"]

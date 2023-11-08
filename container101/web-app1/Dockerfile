#Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim as build

#Information around who maintains the image
MAINTAINER mtopgul

# cd to app directory
WORKDIR /app

# Add the application's jar to the container
COPY target/web-app1.jar .

# Expose port
EXPOSE 8080

#execute the application
#ENTRYPOINT ["java","-jar","/web-app1.jar"]
CMD java -jar web-app1.jar
FROM openjdk:17-slim

LABEL authors="ahmed"

COPY target/loans-microservice.jar loans-microservice.jar

ENTRYPOINT ["java", "-jar", "loans-microservice.jar"]
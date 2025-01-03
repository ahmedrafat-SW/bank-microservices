FROM openjdk:17-slim

LABEL authors="ahmed"

COPY target/cards-microservice.jar cards-microservice.jar

ENTRYPOINT ["java", "-jar", "cards-microservice.jar"]
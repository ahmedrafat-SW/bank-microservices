FROM openjdk:17-slim

LABEL org.opencontainers.image.authors="AHMED RAFAT"

COPY target/accounts-microservice.jar accounts-microservice.jar

ENTRYPOINT ["java", "-jar", "accounts-microservice.jar"]


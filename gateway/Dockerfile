FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/gateway-0.1.jar gateway.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "gateway.jar"]
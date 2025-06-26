FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/ms-peliculas-backend-1.0.0.jar ms-peliculas-backend.jar
EXPOSE 9091
ENV SPRING_PROFILES_ACTIVE=docker
ENV SERVER_PORT=9091
RUN apt-get update && apt-get install -y curl
ENTRYPOINT ["java", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "-jar", "ms-peliculas-backend.jar"]
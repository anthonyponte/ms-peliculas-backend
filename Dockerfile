FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/ms-peliculas-backend-0.0.1-SNAPSHOT.jar ms-peliculas-backend.jar
EXPOSE 9091
RUN apt-get update && apt-get install -y curl
ENTRYPOINT ["java", "-jar", "ms-peliculas-backend.jar"]
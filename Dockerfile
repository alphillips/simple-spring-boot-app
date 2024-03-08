FROM maven:3.8.4-openjdk-11-slim AS build
WORKDIR /app
COPY . . 
RUN mvn clean package -D skipTests


FROM openjdk:8
ADD target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","demo-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080

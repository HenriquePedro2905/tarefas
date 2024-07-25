FROM debian:bullseye AS build

RUN apt-get update && apt-get install -y \
    openjdk-11-jdk \
    maven

WORKDIR /app

COPY . /app

RUN mvn clean install

FROM openjdk:11-jdk

COPY --from=build /app/target/tarefas-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
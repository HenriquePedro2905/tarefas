FROM ubuntu:latest AS build

RUN apt-get update \
    && apt-get install -y openjdk-22-jdk maven

COPY . /app
WORKDIR /app

RUN mvn clean install

FROM openjdk:22-jdk

EXPOSE 8080

COPY --from=build /app/target/tarefas-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
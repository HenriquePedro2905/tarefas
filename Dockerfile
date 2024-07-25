FROM openjdk:21-jdk as build

RUN apt-get update \
    && apt-get install -y maven

COPY . /app
WORKDIR /app
RUN mvn clean install

FROM openjdk:21-jdk

COPY --from=build /app/target/tarefas-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
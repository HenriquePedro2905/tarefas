FROM openjdk:22-jdk AS build

RUN apt-get update && \
    apt-get install -y wget unzip && \
    wget https://downloads.apache.org/maven/maven-3/3.9.0/binaries/apache-maven-3.9.0-bin.zip && \
    unzip apache-maven-3.9.0-bin.zip -d /opt && \
    ln -s /opt/apache-maven-3.9.0 /opt/maven && \
    ln -s /opt/maven/bin/mvn /usr/bin/mvn

WORKDIR /app

COPY . /app

RUN mvn clean install

FROM openjdk:22-jdk

COPY --from=build /app/target/tarefas-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
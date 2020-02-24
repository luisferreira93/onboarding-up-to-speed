FROM maven:3.6.2-jdk-11-slim AS build

ARG JAVA_PACKAGE=java-1.8.0-openjdk-headless
ARG RUN_JAVA_VERSION=1.3.5

WORKDIR /project

COPY text-analysis text-analysis/
COPY pom.xml pom.xml
RUN mvn clean install

WORKDIR /app
COPY target/lib/* /app/lib/
COPY target/*-runner.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT [ "/deployments/run-java.sh" ]

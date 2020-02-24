FROM maven:3.6.2-jdk-11-slim AS build

WORKDIR /project

COPY text-analysis text-analysis/
COPY text-analysis/pom.xml text-analysis/pom.xml

RUN cd text-analysis && mvn clean install

WORKDIR /app

COPY text-analysis/entrypoint.sh ./
COPY text-analysis/target/lib/* /app/lib/
COPY text-analysis/target/*-runner.jar /app/app.jar

EXPOSE 8080

CMD [ "/app/entrypoint.sh" ]

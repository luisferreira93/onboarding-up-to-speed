
FROM openjdk:11

 
ENV SENTENCE="Hello Luis!"
ENV QUARKUS_HOST="0.0.0.0"
ENV QUARKUS_PORT="8080"

WORKDIR /
ADD client-text-analysis/target/client-text-analysis-1.0-SNAPSHOT.jar client.jar
CMD java -jar client.jar -s "$SENTENCE" -h "$QUARKUS_HOST" -p "$QUARKUS_PORT"
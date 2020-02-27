
FROM openjdk:11

 
ENV SENTENCE="Hello Luis!"
ENV HOST="localhost"
ENV PORT="8080"

WORKDIR /
ADD client-text-analysis/target/client-text-analysis-1.0-SNAPSHOT.jar client.jar
CMD java -jar client.jar -s "$SENTENCE" -h "$HOST" -p "$PORT"
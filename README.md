#up-to-speed-backend

## Running the services

In order to initialize the services (Quarkus, Spacy and PostgreSQL), just run the following command:
```
docker-compose up
```
Quarkus will then expose a REST API that will connect to another API (in python) that performs Part-of-Speech Tags (PoS).
All the requests inserted will be persisted in the database, that also runs in a docker.

## Running the Java CLI tool
To run this tool, just go inside the folder client and execute the script run.sh:
```
./run.sh
```

It is possible to change the sentence that is being sent and also the hostname and port to which the tool will send the request.
You just need to change the Dockerfile, more specifically the following environment variables:
```
ENV SENTENCE="Hello Luis!"
ENV HOST="localhost"
ENV PORT="8080"
```

#!/bin/sh
cd client-text-analysis/

#mvn clean
mvn package

cd ..
docker build -t client .
docker run --rm --network host --name client client
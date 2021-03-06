#!/bin/bash

docker stop $(docker ps -aq)
docker rm $(docker ps -aq)
docker run --name postgres -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=postgres -d postgres
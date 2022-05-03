#!/bin/bash
mvn spring-boot:build-image -Dspring-boot.build-image.imageName=$1 -DskipTests
docker tag $1 gcr.io/anthos-book-322415/$1
docker push gcr.io/anthos-book-322415/$1

#!/usr/bin/env bash

set -e

eval "$(minikube docker-env)"
docker buildx build -t demo-scheduling-quartz-postgres .
kubectl apply -f postgres-deployment.yaml
kubectl apply -f spring-boot-deployment.yaml

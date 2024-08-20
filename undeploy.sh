#!/usr/bin/env bash

set -e

kubectl delete deployments.apps demo-scheduling-quartz-posgres-deployment
kubectl delete services demo-scheduling-quartz-postgres-service
kubectl delete deployments.apps postgres-quartz-deployment
kubectl delete services postgres-quartz-service

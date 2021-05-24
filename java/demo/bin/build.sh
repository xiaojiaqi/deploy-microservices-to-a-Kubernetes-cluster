#!/usr/bin/env bash

rm -f Dockerfile
cp Dockerfile.a Dockerfile
docker build -t a.demo.com:v1 ./

rm -f Dockerfile
cp Dockerfile.b Dockerfile
docker build -t b.demo.com:v1 ./

rm -f Dockerfile
cp Dockerfile.c Dockerfile
docker build -t c.demo.com:v1 ./

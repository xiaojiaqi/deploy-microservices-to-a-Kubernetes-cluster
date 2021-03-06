From openjdk:8-alpine
MAINTAINER ppmsn2005@gmail.com
COPY zipkin-server-2.21.6-exec.jar  /usr/bin
ENTRYPOINT ["/bin/sh", "-c", "java ${JAVA_OPTIONS} -jar /usr/bin/zipkin-server-2.21.6-exec.jar"]
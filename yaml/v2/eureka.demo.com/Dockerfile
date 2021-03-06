From nimmis/java-centos:openjdk-8-jdk
MAINTAINER ppmsn2005@gmail.com
COPY eurekaserver-1.0.0.jar  /usr/bin
COPY eureka.sh  /usr/bin
RUN ["/bin/chmod", "+rx", "/usr/bin/eureka.sh"]
ENTRYPOINT ["/bin/sh", "-c", "/usr/bin/eureka.sh"]
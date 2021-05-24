From openjdk:8-alpine
MAINTAINER ppmsn2005@gmail.com
#ÉèÖÃ¶Ë¿Ú
EXPOSE 8761
ADD init.sh /init.sh
ADD eureka.jar /eureka.jar
# reset shell
# RUN rm /bin/sh && ln -s /bin/bash /bin/sh
ENTRYPOINT ["/bin/bash","-c","source /init.sh"]
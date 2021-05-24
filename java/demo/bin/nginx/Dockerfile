From nginx:alpine
MAINTAINER ppmsn2005@gmail.com

RUN mkdir -p /usr/share/nginx/html/www.demo.com
COPY www.demo.com /usr/share/nginx/html/www.demo.com/ 
 
COPY   default.conf  /etc/nginx/conf.d
COPY www.demo.com.conf /etc/nginx/conf.d

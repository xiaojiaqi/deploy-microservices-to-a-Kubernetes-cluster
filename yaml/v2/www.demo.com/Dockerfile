From nginx:alpine
MAINTAINER ppmsn2005@gmail.com

RUN mkdir -p /usr/share/nginx/html/www.demo.com
COPY www/www.demo.com /usr/share/nginx/html/www.demo.com/ 
 
COPY   nginx/default.conf  /etc/nginx/conf.d
COPY nginx/www.demo.com.conf /etc/nginx/conf.d

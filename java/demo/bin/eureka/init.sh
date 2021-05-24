#!/usr/bin/env bash

postFix="svc.cluster.local"
EUREKA_HOST_NAME="$MY_POD_NAME.$MY_IN_SERVICE_NAME.$MY_POD_NAMESPACE.$postFix"
export EUREKA_HOST_NAME=$EUREKA_HOST_NAME

if [ $EUREKA_REPLICAS = 1 ]; then
    echo "the replicas of eureka pod is one"
    BOOL_REGISTER="false"
    BOOL_FETCH="false"
    EUREKA_URL_LIST="http://$EUREKA_HOST_NAME:8761/eureka/,"
    echo " set the EUREKA_URL_LIST is $EUREKA_URL_LIST"
else
    echo "the replicas of the eureka pod is $EUREKA_REPLICAS"
    BOOL_REGISTER="true"
    BOOL_FETCH="true"
    for ((i=0 ;i<$EUREKA_REPLICAS; i ++))
    do
        temp="http://$EUREKA_APPLICATION_NAME-$i.$MY_IN_SERVICE_NAME.$MY_POD_NAMESPACE.$postFix:8761/eureka/,"
        EUREKA_URL_LIST="$EUREKA_URL_LIST$temp"
        echo $EUREKA_URL_LIST
    done
fi
# 这里我简单处理了，每个 pod 的 EUREKA_URL_LIST 都设置成了全部的 pod 域名。使用的时候，可以自行判断，选择不向自己注册。
#例如 eureka-0 的 EUREKA_URL_LIST 可以剔除 http://eureka-0.eureka-service-internal.default.svc.cluster.local:8761/eureka/

export eureka_instance_client_defaultZone=$EUREKA_URL_LIST
 
echo "start jar...."
java -jar /eureka.jar

 
 
    sudo docker pull xiaojiaqi/a.demo.com:v2
    sudo docker pull xiaojiaqi/b.demo.com:v2
    sudo docker pull xiaojiaqi/zipkin.demo.com:v2
    sudo docker pull xiaojiaqi/eureka.demo.com:v2
    sudo docker pull xiaojiaqi/www.demo.com:v2
    sudo docker pull xiaojiaqi/c.demo.com:v2
    sudo docker pull xiaojiaqi/sentinel.demo.com:v2



sudo docker save xiaojiaqi/a.demo.com:v2 -o a.v2.tar.gz
    sudo docker save xiaojiaqi/b.demo.com:v2   -o b.v2.tar.gz
    sudo docker save xiaojiaqi/zipkin.demo.com:v2   -o zip.v2.tar.gz
    sudo docker save xiaojiaqi/eureka.demo.com:v2   -o eur.v2.tar.gz
    sudo docker save xiaojiaqi/www.demo.com:v2      -o www.v2.tar.gz
    sudo docker save xiaojiaqi/c.demo.com:v2         -o c.v2.tar.gz
    sudo docker save xiaojiaqi/sentinel.demo.com:v2   -o sen.v2.tar.gz

for i in a.v2.tar.gz b.v2.tar.gz  c.v2.tar.gz  eur.v2.tar.gz  sen.v2.tar.gz  www.v2.tar.gz  zip.v2.tar.gz ; do sudo docker load -i $i; done



 


kubectl apply -f ./eureka.demo.com/eureka.svc.yaml
 kubectl apply -f ./eureka.demo.com/eureka.yaml
 kubectl apply -f ./eureka.demo.com/export.eureka.yaml

 


 
 kubectl apply -f ./zipkin/zipkin.svc.yaml  
 kubectl apply -f ./zipkin/zipkin.yaml
kubectl apply -f ./zipkin/export.zipkin.yaml  


 kubectl apply -f  ./sentinel/sentinel.yaml
 kubectl apply -f  ./sentinel/sentinel.svc.yaml  
 kubectl apply -f  ./sentinel/export.sentinel.yaml 











kubectl apply -f  ./c.demo.com/c.yaml
kubectl apply -f  ./c.demo.com/c.svc.yaml

kubectl apply -f  ./b.demo.com/b.yaml
kubectl apply -f  ./b.demo.com/b.svc.yaml

kubectl apply -f  ./a.demo.com/a.yaml
kubectl apply -f  ./a.demo.com/a.svc.yaml
kubectl apply -f  ./a.demo.com/export.a.yaml


kubectl apply -f  ./www.demo.com/export.www.yaml
kubectl apply -f  ./www.demo.com/www.svc.yaml
kubectl apply -f  ./www.demo.com/www.yaml




kubectl delete -f ./eureka.demo.com/eureka.svc.yaml
 kubectl delete -f ./eureka.demo.com/eureka.yaml
 kubectl delete -f ./eureka.demo.com/export.eureka.yaml

 


 
 kubectl delete -f ./zipkin/zipkin.svc.yaml  
 kubectl delete -f ./zipkin/zipkin.yaml
kubectl delete -f ./zipkin/export.zipkin.yaml  


 kubectl delete -f  ./sentinel/sentinel.yaml
 kubectl delete -f  ./sentinel/sentinel.svc.yaml  
 kubectl delete -f  ./sentinel/export.sentinel.yaml 




kubectl delete -f  ./c.demo.com/c.yaml
kubectl delete -f  ./c.demo.com/c.svc.yaml

kubectl delete -f  ./b.demo.com/b.yaml
kubectl delete -f  ./b.demo.com/b.svc.yaml

kubectl delete -f  ./a.demo.com/a.yaml
kubectl delete -f  ./a.demo.com/a.svc.yaml
kubectl delete -f  ./a.demo.com/export.a.yaml


kubectl delete -f  ./www.demo.com/export.www.yaml
kubectl delete -f  ./www.demo.com/www.svc.yaml
kubectl delete -f  ./www.demo.com/www.yaml
 




    
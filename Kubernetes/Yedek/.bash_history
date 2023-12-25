gcloud container clusters get-credentials d87springmicrosma --zone europe-west3-c --project d87springmicrosma
kubctl get nodes
kubectl get nodes
kubectl run gc-postgresql --env="POSTGRES_PASSWORD=root" --image=postgres
kubectl get pods
kubectl get nodes
kubectl delete pods gc-postgresql
kubectl get nodes
kubectl get pods
kubectl run gc-postgresql --env="POSTGRES_PASSWORD=root" --image=postgres
kubectl get pods
kubectl get nodes
kubectl get pods
kubectl get nodes
kubectl get pods
kubectl apply -f pod_postgre.yml 
kubectl get pods
kubectl delete pods all
kubectl delete pods gc-postgresql
kubectl delete pods postgresql
kubectl get pods
kubectl apply -f deployment_postgres.yml 
kubectl get pods
kubectl get deployments
kubectl get pods -w
kubectl get pods
kubectl get deployments
kubectl delete deployments deployment-postgresql
kubectl get deployments
kubectl get pods
kubectl apply -f deployment_postgres.yml 
kubectl get pods
kubectl apply -f deployment_postgres.yml 
kubectl get pods
kubectl get deployments
kubectl get pods
kubectl apply -f service_postgres.yml 
kubectl get services
kubectl get pods
kubectl apply -f deployment_postgres.yml 
kubectl get pods
kubectl apply -f deployment_mongodb.yml 
kubectl get pods
kubectl get deployment
kubectl get services
kubectl get deployment
kubectl delete deployments deployment-mongodb
kubectl get deployment
kubectl get pods
kubectl apply -f deployment_mongodb.yml 
kubectl get pods
kubectl apply -f service_loadbalancer_mongodb.yml
kubectl get services
kubectl delete services service-mongodb
kubectl get services
kubectl get deployment
kubectl delete deployment deployment-mongodb
kubectl get services
kubectl get pods
kubectl apply -f deployment_mongodb.yml 
kubectl get pods
kubectl apply -f service_loadbalancer_mongodb.yml
kubectl get services
kubectl get pods
kubectl get services
kubectl apply -f deployment_configserver.yml 
kubectl get pods
kubectl get deployment
kubectl delete deployment deployment-configserver
kubectl get deployment
kubectl apply -f deployment_configserver.yml 
kubectl get deployment
kubectl get pods
kubectl logs -f deployment_configserver-78554d76dc-lqdsd
kubectl get pods
kubectl apply -f deployment_zipkin.yml 
kubectl get pods
kubectl get services
kubectl get deployment
kubectl get deployments
kubectl apply -f deployment_redis.yml 
kubectl get deployments
kubectl get pods
kubectl apply -f deployment_elastic.yml 
kubectl get pods
kubectl get deployments
kubectl get pods
kubectl get services
kubectl get pods
kubectl get pods -o wide
kubectl delete pods zipkin-677b75fdd7-qhb99
kubectl get pods -o wide
kubectl get services
kubectl delete pods deployment-mongodb-74c4d548c4-2v6vv
kubectl delete pods deployment-mongodb-74c4d548c4-x9xzr
kubectl get pods -o wide
kubectl get services
kubectl apply -f deployment_configserver.yml 
kubectl get pods
kubectl logs -f deployment-configserver-6bf774ccfb-k6h8b
kubectl get pods
kubectl get pods -o wide
kubectl describe pods deployment-configserver-6bf774ccfb-k6h8b
kubectl logs -f deployment-configserver-6bf774ccfb-k6h8b
kubectl apply -f service_clusterip_zipkin.yml 
kubectl get services
kubectl get pods -o wide
kubctl get node
kubctl get nodes
kubectl get pods
kubectl get nodes
kubectl get node
kubectl get pods
kubectl get services
kubectl get deployment
kubectl get pods
kubectl get pods -o wide
kubectl get services
kubectl get deployments
kubectl get services
kubectl apply -f service_clusterip_configserver.yml
kubectl get services
kubectl apply -f service_loadbalancer_authservice.yml 
kubectl apply -f service_loadbalancer_userprofileservice.yml 
kubectl get services
kubectl get pods -o wide
kubectl get pods
kubectl apply -f deployment_rabbitmq.yml 
kubectl get pods
kubectl get pods -o wide
kubectl get services
kubectl get deployments
kubectl apply -f deployment_configserver.yml 
kubectl get services
kubectl get pods
kubectl get nodes
kubectl get pods
kubectl get services
kubectl get deployments
kubectl get services
kubectl get pods
kubectl logs deployment-configserver-6857c96d65-b4hm6
kubectl logs -f  deployment-configserver-6857c96d65-b4hm6
kubectl get pods
kubectl apply -f deployment_configserver.yml 
kubectl get pods
kubectl apply -f deployment_configserver.yml 
kubectl get services
kubectl apply -f deployment_configserver.yml 
kubectl get services
kubectl apply -f deployment_configserver.yml 
kubectl get services
kubectl get pods
kubectl logs -f deployment-configserver-6857c96d65-x5slp
kubectl get services
kubectl get pods
kubectl delete deployments deployment-configserver-6b774ccfb-k6h8b
kubectl get deployments
kubectl get pods
kubectl delete pods deployment-configserver-6bf774ccfb-k6h8b
kubectl get pods
kubectl get services
kubectl get pods
kubectl get deployments
kubectl get pods
kubectl get services
kubectl logs -f deployment-configserver-6857c96d65-x5slp
kubectl get services
kubectl apply -f deployment_authservice.yml 
kubectl apply -f deployment_userprofileservice.yml 
kubectl get pods
kubectl logs -f deployment-authservice-6f5fbbc6bf-jw4ch
kubectl apply -f deployment_userprofileservice.yml 
kubectl get pos
kubectl get pods
kubectl delete pods deployment-authservice-6f5fbbc6bf-jw4ch
kubectl get pods
kubectl delete pods deployment-userprofileservice-5849cc94f5-mqpqt
kubectl get pods
kubectl logs -f deployment-authservice-6f5fbbc6bf-2kcw2
kubectl get services
kubectl logs -f deployment-authservice-6f5fbbc6bf-2kcw2
kubectl get pods
kubectl apply -f deployment_userprofileservice.yml 
kubectl apply -f deployment_authservice.yml
kubectl get pods
kubectl get deployments
kubectl apply -f deployment_authservice.yml
kubectl get pods
kubectl apply -f deployment_authservice.yml
kubectl get pods
kubectl delete pods deployment-authservice-6f5fbbc6bf-2kcw2
kubectl get pods
kubectl delete pods deployment-authservice-6d44fdb9db-qnpt4
kubectl get pods
kubectl get services
kubectl get deployments
kubectl get pods
kubectl get services
kubectl get pods
kubectl get deployments
kubectl delete deployments deployment-authservice
kubectl get pods
kubectl apply -f deployment_authservice.yml
kubectl get pods
kubectl delete pods deployment-authservice-6f5fbbc6bf-jt5hm
kubectl get pods
kubectl delete pods deployment-userprofileservice-5849cc94f5-bkz49
kubectl get pods
kubectl get deployments
kubectl get pods
kubectl describe pods deployment-authservice-6f5fbbc6bf-b2gjw
kubectl describe nodes
kubectl get pods
kubectl apply -f deployment_authservice.yml
kubectl apply -f deployment_userprofileservice.yml 
kubectl get pods
kubectl delete pods deployment-userprofileservice-ff78d875d-4bxbz
kubectl delete pods deployment-userprofileservice-5849cc94f5-8vjjk
kubectl get pods
kubectl get deployments
kubectl delete deployment-userprofileservice
kubectl get deployments
kubectl delete deployments  deployment-userprofileservice
kubectl get deployments
kubectl apply -f deployment_userprofileservice.yml 
kubectl get pods
kubectl get describe deployment-userprofileservice-ff78d875d-d5pxv
kubectl describe pods deployment-userprofileservice-ff78d875d-d5pxv
kubectl describe nodes 
kubectl apply -f deployment_postgres.yml 
kubectl apply -f deployment_mongodb.yml 
kubectl apply -f deployment_userprofileservice.yml 
kubectl get pods
kubectl describe nodes
kubectl get pods
kubectl get services
kubectl get pods
kubectl describe pods deployment-userprofileservice-ff78d875d-d5pxv
kubectl logs -f deployment-userprofileservice-ff78d875d-d5pxv
kubectl delete pods deployment-userprofileservice-ff78d875d-d5pxv
kubectl get pods
kubectl delete pods deployment-userprofileservice-ff78d875d-d5pxv
kubectl get pods
kubectl logs -f deployment-userprofileservice-ff78d875d-d22n6
kubectl get pods
kubectl delete pods deployment-userprofileservice-ff78d875d-d22n6
kubectl get pods
kubectl logs -f deployment-userprofileservice-ff78d875d-jrbwb
kubectl get pods
kubectl logs -f deployment-userprofileservice-ff78d875d-jrbwb
kubectl get pods
kubectl logs -f deployment-userprofileservice-ff78d875d-jrbwb
kubectl get pods
kubectl logs -f deployment-userprofileservice-ff78d875d-jrbwb
kubectl get pods
kubectl logs -f deployment-userprofileservice-ff78d875d-jrbwb
kubectl get pods
kubectl get deployments
kubectl delete deployments deployment-userprofileservice
kubectl apply -f deployment_userprofileservice.yml 
kubectl get pods
kubectl logs -f deployment-userprofileservice-ff78d875d-khlpk
kubectl get pods
kubectl apply -f deployment_userprofileservice.yml 
kubectl get pods
kubectl logs -f deployment-userprofileservice-764877c945-r4wzg
kubectl apply -f deployment_userprofileservice.yml 
kubectl apply -f deployment_authservice.yml 
kubectl get pods
kubectl apply -f deployment_userprofileservice.yml 
kubectl apply -f deployment_authservice.yml 
kubectl get pods
kubectl describe pods deployment-authservice-6f5fbbc6bf-qhxdb 
kubectl apply -f deployment_authservice.yml 
kubectl apply -f deployment_userprofileservice.yml 
kubectl get pods
kubectl describe pods deployment-userprofileservice-5887b45db7-x9bxw
kubectl apply -f deployment_userprofileservice.yml 
kubectl apply -f deployment_authservice.yml 
kubectl get pods
kubectl describe nods
kubectl describe nodes
kubectl get pods
kubectl apply -f deployment_authservice.yml 
kubectl apply -f deployment_userprofileservice.yml 
kubectl get pods
kubectl describe nodes
kubectl get pods
kubectl delete pods deployment-userprofileservice-77986c4867-2kzms
kubectl get pods
kubectl describe nodes
kubectl apply -f deployment_userprofileservice.yml 
kubectl get pods
kubectl apply -f deployment_authservice.yml 
kubectl get pods
kubectl get services
kubectl get pods
kubectl get services
kubectl get pods
kubectl get wide -o pods
kubectl get wide pods
kubectl wide -o pods
kubectl get pods wide -o
kubectl get pods -o wide
kubectl get services
kubectl get pods -o wide
kubectl get services
kubectl describe nodes
kubectl apply -f deployment_gateway.yml 
kubectl apply -f service_loadbalancer_gateway.yml 
kubectl get pods -o wide
kubectl get pods
kubectl get services
kubectl get pods
kubectl logs -f deployment-apigateway-77548ccfc6-jp6lk
kubectl describe deployment-apigateway-77548ccfc6-jp6lk
kubectl describe pods deployment-apigateway-77548ccfc6-jp6lk
kubectl logs -f deployment-apigateway-77548ccfc6-jp6lk
kubectl get pods
kubectl delete pods deployment-apigateway-77548ccfc6-jp6lk
kubectl get pods
kubectl logs -f deployment-apigateway-77548ccfc6-jp6lk
kubectl logs -f deployment-apigateway-77548ccfc6-vk499 
kubectl describe pods 
kubectl get pods -w
kubectl get services
kubectl describe services service-authservice 
kubectl get pods -o wide

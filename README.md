# microservicos-rabbitmq
Spring Cloud, microserviços, rabbitMQ, Keycloak

Rodar o rabbitMQ através do docker
docker run -it --name rabbitmq-ms -p 5672:5672 -p 15672:15672 rabbitmq:3.13-management

Rodar o Keycloak através do docker
docker run --name keycloak-ms -p 8081:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:25.0.1 start-dev

FROM openjdk:21
COPY ./target/cloud-gateway-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/app.jar"]
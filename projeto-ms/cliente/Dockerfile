FROM openjdk:21
COPY ./target/cliente-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/app.jar"]
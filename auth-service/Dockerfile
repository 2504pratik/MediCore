FROM openjdk:8

EXPOSE 8084

ADD ../target/auth-service-1.0-SNAPSHOT.jar auth-service-1.0-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/auth-service-1.0-SNAPSHOT.jar"]
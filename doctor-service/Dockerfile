FROM openjdk:8

EXPOSE 8082

ADD ../target/doctor-service-1.0-SNAPSHOT.jar doctor-service-1.0-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/doctor-service-1.0-SNAPSHOT.jar"]
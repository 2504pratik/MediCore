FROM openjdk:8

EXPOSE 8081

ADD ../target/patient-service-1.0-SNAPSHOT.jar patient-service-1.0-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/patient-service-1.0-SNAPSHOT.jar"]
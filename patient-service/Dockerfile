FROM openjdk:8

EXPOSE 8081

ADD target/patient-service.jar patient-service.jar

ENTRYPOINT["java","-jar","/patient-service.jar"]
FROM openjdk:8

EXPOSE 8082

ADD target/doctor-service.jar doctor-service.jar

ENTRYPOINT["java","-jar","/doctor-service.jar"]
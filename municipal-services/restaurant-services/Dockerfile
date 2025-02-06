FROM openjdk:8
ADD target/billing-service.jar billing-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","billing-service.jar"]
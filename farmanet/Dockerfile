FROM openjdk:11.0.6-jre
MAINTAINER Rodrigo Sepulveda (r.sepulveda.a@gmail.com)
ADD target/farm-spring-boot.jar farm-spring-boot.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "farm-spring-boot.jar"]
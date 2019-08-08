FROM openjdk:8
MAINTAINER Radiant Digital
EXPOSE 3256
ADD target/*.jar /msa-customer.jar
RUN bash -c 'touch /msa-customer.jar'
CMD ["java","-Dspring.profiles.active=docker","-jar","/msa-customer.jar"]
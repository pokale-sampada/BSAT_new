FROM openjdk:8
EXPOSE 8090
ADD target/bsat-r3.jar bsat-r3.jar
ENTRYPOINT ["java","-jar","/bsat-r3.jar"]


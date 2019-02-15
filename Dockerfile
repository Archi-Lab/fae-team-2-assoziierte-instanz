#Basis Image
FROM openjdk:12-jdk-alpine
#Port Freigeben für Docker
EXPOSE 8021
#Kopieren des Artefakts auf den Container
COPY target/microservice_assoziierte_instanz-0.0.1-SNAPSHOT.jar app.jar
#Startpunkt für den Service festlegen
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","./app.jar"]
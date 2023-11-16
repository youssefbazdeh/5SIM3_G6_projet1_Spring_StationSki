#spécifie la base de l'image Docker.
FROM openjdk:11-jre-slim
#EXPOSE: expose des ports dans l'image Docker.
EXPOSE 8089
ADD target/stationSki-1.1.0.jar stationSki-1.1.0.jar
ENTRYPOINT ["java","-jar","/stationSki-1.1.0.jar"]
# Use a temporary image to download the JAR file
FROM alpine AS downloader

# Install curl to fetch the JAR from Nexus
RUN apk --no-cache add curl

# Download the JAR file from Nexus
ARG NEXUS_URL=http://192.168.229.33:8081/repository/maven-releases/com.example/stationSki/1.1.0/stationSki-1.1.0.jar
RUN curl -L -o /stationSki-1.1.0.jar ${NEXUS_URL}

# Use the base image with Java Runtime
FROM openjdk:11-jre-slim

# Expose the port the app runs on
EXPOSE 8089

# Copy the downloaded JAR file from the downloader image
COPY --from=downloader /stationSki-1.1.0.jar /stationSki-1.1.0.jar

# Command to run the application
ENTRYPOINT ["java","-jar","/stationSki-1.1.0.jar"]


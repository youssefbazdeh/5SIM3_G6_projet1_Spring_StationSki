# Use the base image with Java Runtime
FROM openjdk:11-jre-slim

# Expose the port the app runs on
EXPOSE 8089

# Create a directory for the app
WORKDIR /app

# Copy the JAR file from the local target directory
COPY target/stationSki-1.1.0.jar /app/

# Command to run the application
ENTRYPOINT ["java", "-jar", "stationSki-1.1.0.jar"]

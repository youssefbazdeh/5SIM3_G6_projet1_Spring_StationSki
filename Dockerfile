FROM openjdk:11-jre-slim
EXPOSE 8082
ADD target/5sim3-g6-projet1-1.0.jar 5sim3-g6-projet1-1.0.jar
ENTRYPOINT ["java","-jar","/5sim2-g6-projet1-1.0.jar"]

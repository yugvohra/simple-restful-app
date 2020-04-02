FROM openjdk:11-jre-slim
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} restfulApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/restfulApp-0.0.1-SNAPSHOT.jar"]
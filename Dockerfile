# First stage: Build the Java application
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app

# Copy the pom.xml and the source code
COPY pom.xml .
COPY src ./src

# Build the application and create the JAR file
RUN mvn clean package -DskipTests

# Second stage: Create the final image
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app

# Copy the JAR file from the first stage
COPY --from=build /app/target/sample-app-0.0.1-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]


#FROM openjdk:11
#ARG JAR_FILE=target/sample-app.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"] 
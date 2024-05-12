# Use the official OpenJDK image as base
FROM openjdk:17-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the packaged Spring Boot application JAR file into the container
COPY target/library-management-api-*.jar library-management-api.jar
# Expose port 8081
EXPOSE 8081

# Command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "library-management-api.jar"]

# Set environment variables
ENV SPRING_DATASOURCE_URL jdbc:mysql://<database-host>:<database-port>/<database-name>
ENV SPRING_DATASOURCE_USERNAME <database-username>
ENV SPRING_DATASOURCE_PASSWORD <database-password>

# Use a lightweight Java 17 runtime
FROM eclipse-temurin:17-jre

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target folder into the container
COPY target/userauth-0.0.1-SNAPSHOT.jar app.jar

# Expose port 5600 (since your application listens on 5600)
EXPOSE 5600

# Run the application with optimized JVM settings
ENTRYPOINT ["java", "-jar", "app.jar"]

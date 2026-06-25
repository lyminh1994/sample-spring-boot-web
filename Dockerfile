FROM amazoncorretto:17.0.19-alpine3.23
WORKDIR /app
# 1. Create a system group and user Create the logs directory and set permissions
# -S creates a system user/group
# -G assigns the user to the specified group
# We do this while still 'root' so we have permission to create folders \
RUN addgroup -S springgroup && adduser -S springuser -G springgroup \
 && mkdir logs && chown -R springuser:springgroup /app/logs
# 3. Copy the JAR file
COPY target/*.jar app.jar
# 4. Change ownership of the application file to the new user
RUN chown springuser:springgroup app.jar
# 4. Switch to the non-root user
USER springuser
EXPOSE 9090
ENTRYPOINT ["java","-jar","app.jar"]

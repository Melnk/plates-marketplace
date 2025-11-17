FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY pom.xml mvnw ./
RUN if [ -f mvnw ]; then  ./mvnw -v || true; fi
COPY src src
RUN ./mvnw -q -DskipTests package
EXPOSE 8080
CMD ["java", "-jar", "/app/target/plates-market-0.0.1-SNAPSHOT.jar"]

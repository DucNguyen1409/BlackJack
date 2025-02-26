FROM openjdk:17-jdk-slim
COPY target/ghidiem-1.0.0.jar ghidiem.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "ghidiem.jar"]
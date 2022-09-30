FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /app
COPY . .
RUN ./gradlew bootJar

FROM eclipse-temurin:17-jre-alpine
ARG PORT_BUILD=9000
ENV PORT_EXEC=${PORT_BUILD}
EXPOSE ${PORT_BUILD}
COPY --from=builder /app/build/libs/*-SNAPSHOT.jar app.jar
ENTRYPOINT java -jar app.jar --server.port=${PORT_EXEC}

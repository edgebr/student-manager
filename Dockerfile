FROM gradle:8.5.0-jdk17-alpine AS build

WORKDIR /app
COPY --chown=gradle:gradle . /app
RUN  --mount=type=cache,target=/root/.gradle ./gradlew build --stacktrace

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
FROM openjdk:17-alpine AS build


COPY pom.xml mvnw ./
COPY .mvn .mvn

COPY src ./src

RUN ./mvnw clean install

WORKDIR fileapp
COPY --from=build target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]





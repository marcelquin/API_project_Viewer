FROM maven:3.8.6-amazoncorretto-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package -X -DskipTests

FROM openjdk:17-alpine3.14
WORKDIR /app
COPY --from=build ./app/target/*.jar ./apirest.jar
ENTRYPOINT java -jar apirest.jar
EXPOSE 8091
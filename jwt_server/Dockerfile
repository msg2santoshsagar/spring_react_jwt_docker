# Stage 1
FROM maven:3.5-jdk-8-alpine as mvn-build
WORKDIR /app
COPY . ./
#RUN ls
RUN mvn install

# Stage 2 - the production environment
FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=mvn-build /app/target/jwt_server.jar /app
EXPOSE 8085
ENTRYPOINT ["sh", "-c"]
CMD ["java -jar jwt_server.jar"]
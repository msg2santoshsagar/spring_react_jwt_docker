FROM alpine/git
WORKDIR /app
RUN git clone https://github.com/msg2santoshsagar/spring_react_jwt_docker.git

FROM maven:3.5-jdk-8-alpine
WORKDIR /app
COPY --from=0 /app/spring_react_jwt_docker/jwt_server /app
RUN mvn install

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=1 /app/target/jwt_server.jar /app
EXPOSE 8081
ENTRYPOINT ["sh", "-c"]
CMD ["java -jar jwt_server.jar"]
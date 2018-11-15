FROM maven:3.5-jdk-8-alpine
#WORKDIR /
RUN mvn install
RUN ls

FROM openjdk:8-jre-alpine
WORKDIR /
COPY --from=0 /target/jwt_server.jar /
EXPOSE 8085
ENTRYPOINT ["sh", "-c"]

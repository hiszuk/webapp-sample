FROM gradle AS build
WORKDIR /home/gradle/project
ENV GRADLE_USER_HOME /home/gradle/project/gradle

COPY . .
RUN gradle build

FROM openjdk:8-jdk-alpine
COPY --from=build /home/gradle/project/build/libs/webapi-1.0.0-SNAPSHOT.jar /app.jar
ENV JAVA_OPS="-Xms64m -Xmx512m"
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar

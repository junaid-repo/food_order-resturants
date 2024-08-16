FROM openjdk:17-jdk-alpine

COPY target/resturants-0.0.1-SNAPSHOT.jar resturants-1.0.0.jar

ENTRYPOINT [ "java", "-jar", "resturants-1.0.0.jar" ]

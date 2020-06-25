FROM openjdk:8-jdk-alpine

VOLUME /tmp

ADD ./target/app.jar ./

ENTRYPOINT ["java","-jar","/app.jar"]
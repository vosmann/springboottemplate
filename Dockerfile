FROM zalando/openjdk:8u45-b14-5

WORKDIR /opt/springboottemplate

EXPOSE 10001

ENV VERSION 1.0-SNAPSHOT

ADD target/springboottemplate-$VERSION.jar server.jar
RUN chmod -R 770 /opt/springboottemplate

ENTRYPOINT ["java", "-jar", "server.jar"]

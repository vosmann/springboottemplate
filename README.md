# Spring Boot Template

This is an empty Spring Boot project. It helps bootstrap projects by providing:

* An empty project structure
* Maven building
* Request metrics
* JVM metrics over Jolokia
* Docker image building
* Senza deployments to AWS
* Stack creation-time parametrization

To build, do:

    mvn clean package

You can run the program like this:

    java -jar target/springboottemplate-1.0-SNAPSHOT.jar

To create a Docker container, run:

    docker build -t your.registry.com/team/springboottemplate:1.0-SNAPSHOT .

Creating EC2 instance that will run this program, you can use the example Senza template in
`example.yaml`. A better option would be to initialize your own Senza template.

    senza init server.yaml


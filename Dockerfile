FROM openjdk:8u191-jdk-alpine
ADD target/CadPessoa-0.0.1-SNAPSHOT.jar CadPessoa-0.0.1-SNAPSHOT.jar
ENTRYPOINT java -jar CadPessoa-0.0.1-SNAPSHOT.jar
EXPOSE 8080

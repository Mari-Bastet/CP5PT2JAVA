# Use uma imagem base do OpenJDK
FROM openjdk:17-oracle


WORKDIR /app

ADD https://github.com/Mari-Bastet/CP4PT2JAVA/releases/download/v1/cpjava-0.0.1-SNAPSHOT.jar /app/cpjava-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/cpjava-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080

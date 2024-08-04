# Usando uma imagem base do Java 17
FROM openjdk:17-jdk-slim

# Adiciona um volume apontando para /tmp
VOLUME /tmp

# O argumento JAR_FILE define onde o JAR será colocado
ARG JAR_FILE=target/order-generator-0.0.1-SNAPSHOT.jar

# Adiciona o JAR do aplicativo ao contêiner
COPY ${JAR_FILE} app.jar

# Expõe a porta que a aplicação utiliza
EXPOSE 8081

# Executa o JAR do aplicativo
ENTRYPOINT ["java","-jar","/app.jar"]

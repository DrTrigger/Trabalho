# Passo 1: Usar uma imagem base com Java
FROM openjdk:23-jdk-slim

# Passo 2: Definir o diretório de trabalho dentro do container
WORKDIR /app

# Passo 3: Copiar o arquivo .jar do seu projeto para o container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Passo 4: Especificar o comando para rodar o .jar
ENTRYPOINT ["java", "-jar", "app.jar"]

# Passo 5: Expor a porta 8080 para comunicação
EXPOSE 8080

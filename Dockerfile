FROM openjdk:17-slim
VOLUME /tmp

# Atualiza o sistema e instala o Maven
RUN apt-get update && apt-get install -y maven

# Copia o arquivo pom.xml e faz o download das dependências com Maven
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o restante do projeto e executa o build com Maven
COPY . .
RUN mvn clean install -DskipTests

# Expõe a porta em que a aplicação estará rodando
EXPOSE 8080

CMD ["java", "-javaagent:/app/opentelemetry-javaagent.jar", "-jar", "target/SpringBootCRUDWithSplunkIntegration-0.0.1-SNAPSHOT.jar"]


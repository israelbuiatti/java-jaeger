FROM openjdk:17-jdk
VOLUME /tmp
COPY target/*.jar myapp.jar

#ENTRYPOINT ["java", "-javaagent:/app/opentelemetry-javaagent.jar", "-jar", "/myapp.jar"]

#
# FROM openjdk:17-jdk
#
# VOLUME /tmp
#
# #WORKDIR /app
#
# COPY target/*.jar /app/myapp.jar
#
# #ENTRYPOINT ["java", "-javaagent:/app/opentelemetry-javaagent.jar", "-jar", "/app/myapp.jar"]

CMD ["java", "-javaagent:/app/opentelemetry-javaagent.jar", "-jar", "/myapp.jar"]


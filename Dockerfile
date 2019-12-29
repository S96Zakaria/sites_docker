FROM openjdk:8
ADD target/java_app.jar java_app.jar
ENTRYPOINT ["java","-jar","java_app.jar"]
EXPOSE 8086
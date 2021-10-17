FROM openjdk:11

ADD target/loan-app.jar loan-app.jar

ENTRYPOINT ["java", "-jar","loan-app.jar"]

EXPOSE 8080
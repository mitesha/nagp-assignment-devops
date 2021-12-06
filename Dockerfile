FROM amazoncorretto:11-alpine3.14

COPY target/nagp-assignment-devops-0.0.1-SNAPSHOT.jar /var/lib/app.jar

ENTRYPOINT ["java", "-jar", "/var/lib/app.jar"]
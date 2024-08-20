FROM amazoncorretto:21.0.4-al2023
EXPOSE 8080
COPY target/demo-scheduling-quartz-postgres-0.0.1-SNAPSHOT.jar demo-scheduling-quartz-postgres-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","demo-scheduling-quartz-postgres-0.0.1-SNAPSHOT.jar"]

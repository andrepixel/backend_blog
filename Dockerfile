FROM openjdk:17-jdk-alpine
COPY build/libs/backend_blog-0.0.1-SNAPSHOT.jar backend_blog-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/backend_blog-0.0.1-SNAPSHOT.jar"]
FROM openjdk:17-jdk-alpine
COPY . /
WORKDIR /
CMD ["./gradlew build"]
ENTRYPOINT ["java","-jar","/backend_blog-0.0.1-SNAPSHOT.jar"]
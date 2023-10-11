FROM openjdk:17-jdk-alpine
COPY . /src
WORKDIR /src
RUN ./gradlew build
ADD /src/build/libs/backend_blog-0.0.1-SNAPSHOT.jar backend_blog-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","backend_blog-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
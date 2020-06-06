FROM openjdk:11
COPY ./build/libs/todo-graphql-api-0.0.1-SNAPSHOT.jar /opt/todo-graphql-api/
WORKDIR /opt/todo-graphql-api/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "todo-graphql-api-0.0.1-SNAPSHOT.jar"]

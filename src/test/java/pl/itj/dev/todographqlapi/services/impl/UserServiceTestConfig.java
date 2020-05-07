package pl.itj.dev.todographqlapi.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import pl.itj.dev.todographqlapi.model.User;
import pl.itj.dev.todographqlapi.services.ifc.UserService;

import java.util.List;
import java.util.UUID;

@TestConfiguration
public class UserServiceTestConfig {

    @Bean
    public List<User> usersList() {
        User firstUser = new User();
        User secondUser = new User();
        User thirdUser = new User();

        firstUser.setId(UUID.fromString("f4b412d2-87e9-11ea-bc55-0242ac130000"));
        firstUser.setUsername("first_user");

        secondUser.setId(UUID.randomUUID());
        secondUser.setUsername("second_user");

        thirdUser.setId(UUID.randomUUID());
        thirdUser.setUsername("third_user");

        return List.of(firstUser, secondUser, thirdUser);
    }

    @Bean
    public GraphQLSchema graphQLSchema(UserService userService) {
        return new GraphQLSchemaGenerator()
                .withOperationsFromSingleton(userService)
                .generate();
    }

    @Bean
    public GraphQL graphQL(GraphQLSchema graphQLSchema) {
        return GraphQL.newGraphQL(graphQLSchema).build();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}

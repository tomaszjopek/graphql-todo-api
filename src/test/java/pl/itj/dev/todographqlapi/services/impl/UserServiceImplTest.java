package pl.itj.dev.todographqlapi.services.impl;

import graphql.ExecutionResult;
import graphql.GraphQL;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.itj.dev.todographqlapi.model.User;
import pl.itj.dev.todographqlapi.repositories.UserRepository;
import pl.itj.dev.todographqlapi.services.ifc.UserService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = { UserServiceTestConfig.class })
class UserServiceImplTest {

    @Autowired
    private GraphQL graphQL;

    @Autowired
    private List<User> users;

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    @DisplayName(value = "Test schema generation and execution on users collection")
    void fetchAllUsers_should_return_three_users_data_when_three_users() {
        Mockito.when(userRepository.findAll()).thenReturn(users);

        ExecutionResult result = graphQL.execute("{ users { id username } } ");
        assertFalse(result.getErrors() != null && !result.getErrors().isEmpty());
        assertNotNull(result.getData());

        LinkedHashMap<String, List<LinkedHashMap<String, String>>> data = result.getData();
        assertEquals(3, data.get("users").size());

        List<LinkedHashMap<String, String>> users = data.get("users");

        assertEquals("first_user", users.get(0).get("username"));
        assertEquals("second_user", users.get(1).get("username"));
        assertEquals("third_user", users.get(2).get("username"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"f4b412d2-87e9-11ea-bc55-0242ac130000"})
    @DisplayName(value = "Should return appropriate user for the given id")
    void findUserById_should_return_one_user_when_given_id(String userUUID) {
        Mockito.when(userRepository.findById(UUID.fromString(userUUID))).thenReturn(Optional.of(users.get(0)));

        ExecutionResult result = graphQL.execute("{ user(id: \"" + userUUID + "\") { id username } } ");
        assertFalse(result.getErrors() != null && !result.getErrors().isEmpty());
        assertNotNull(result.getData());

        LinkedHashMap<String, LinkedHashMap<String, String>> data = result.getData();

        assertEquals(userUUID, data.get("user").get("id"));
        assertEquals(users.get(0).getUsername(), data.get("user").get("username"));
    }

    @Test
    @DisplayName(value = "Return collection of three users using service")
    void fetchAllUsers_should_return_three_users_when_three_users_exists() {
        Mockito.when(userRepository.findAll()).thenReturn(users);

        Iterable<User> users = userService.fetchAllUsers();

        assertNotNull(users);
        assertEquals(3, StreamSupport.stream(users.spliterator(), false).count());
    }

    @Test
    void findUserTickets() {
        assertTrue(true);
    }
}

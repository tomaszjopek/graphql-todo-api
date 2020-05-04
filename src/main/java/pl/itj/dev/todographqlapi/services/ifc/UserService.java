package pl.itj.dev.todographqlapi.services.ifc;

import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLEnvironment;
import io.leangen.graphql.execution.ResolutionEnvironment;
import pl.itj.dev.todographqlapi.exceptions.data.UserNotFoundException;
import pl.itj.dev.todographqlapi.model.Ticket;
import pl.itj.dev.todographqlapi.model.User;

import java.util.UUID;

public interface UserService {

    Iterable<User> fetchAllUsers();
    User findUserById(UUID id, @GraphQLEnvironment ResolutionEnvironment resolutionEnvironment) throws UserNotFoundException;
    Iterable<Ticket> findUserTickets(@GraphQLContext User user);

}

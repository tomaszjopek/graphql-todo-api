package pl.itj.dev.todographqlapi.services.ifc;

import io.leangen.graphql.annotations.GraphQLTypeResolver;
import pl.itj.dev.todographqlapi.model.Ticket;
import pl.itj.dev.todographqlapi.model.User;

import java.util.UUID;

public interface UserService {

    Iterable<User> fetchAllUsers();
    User findUserById(UUID id);
    Iterable<Ticket> findUserTickets(UUID userId);

}

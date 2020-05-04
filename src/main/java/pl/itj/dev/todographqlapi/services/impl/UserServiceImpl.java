package pl.itj.dev.todographqlapi.services.impl;

import com.google.common.base.Stopwatch;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLEnvironment;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.execution.ResolutionEnvironment;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.itj.dev.todographqlapi.exceptions.data.UserNotFoundException;
import pl.itj.dev.todographqlapi.model.Ticket;
import pl.itj.dev.todographqlapi.model.User;
import pl.itj.dev.todographqlapi.repositories.UserRepository;
import pl.itj.dev.todographqlapi.services.ifc.UserService;

import java.util.UUID;

@Service
@GraphQLApi
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @GraphQLQuery(name = "users", description = "Get all users query")
    public Iterable<User> fetchAllUsers() {
        Stopwatch timer = Stopwatch.createStarted();
        var users = userRepository.findAll();
        log.info("[fetchAllUsers] Method took: {}", timer.stop());
        return users;
    }

    @Override
    @GraphQLQuery(name = "userById", description = "Get user by id")
    public User findUserById(UUID id, @GraphQLEnvironment ResolutionEnvironment resolutionEnvironment) throws UserNotFoundException {
        Stopwatch timer = Stopwatch.createStarted();
        var user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id, User.class));
        log.info("[findUserById] Method took: {}", timer.stop());
        return user;
    }

    @Override
    @GraphQLQuery(name = "tickets")
    public Iterable<Ticket> findUserTickets(@GraphQLContext User user) {
        Stopwatch timer = Stopwatch.createStarted();
        var tickets = user.getTickets();
        log.info("[findUserTickets] Method took: {}", timer.stop());
        return tickets;
    }
}

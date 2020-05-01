package pl.itj.dev.todographqlapi.services.impl;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Service;
import pl.itj.dev.todographqlapi.model.Ticket;
import pl.itj.dev.todographqlapi.model.User;
import pl.itj.dev.todographqlapi.repositories.UserRepository;
import pl.itj.dev.todographqlapi.services.ifc.UserService;

import java.util.UUID;

@Service
@GraphQLApi
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @GraphQLQuery(name = "users", description = "Get all users query")
    public Iterable<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Iterable<Ticket> findUserTickets(UUID userId) {
        return userRepository.findById(userId).get().getTickets();
    }

    @Override
    public User findUserById(UUID id) {
        return null;
    }
}

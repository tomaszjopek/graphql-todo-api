package pl.itj.dev.todographqlapi.services.impl;

import com.google.common.base.Stopwatch;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.itj.dev.todographqlapi.exceptions.data.TicketNotFoundException;
import pl.itj.dev.todographqlapi.model.State;
import pl.itj.dev.todographqlapi.model.Ticket;
import pl.itj.dev.todographqlapi.model.User;
import pl.itj.dev.todographqlapi.repositories.TicketRepository;
import pl.itj.dev.todographqlapi.services.ifc.TicketService;

import java.util.UUID;

@Service
@GraphQLApi
@Slf4j
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    @GraphQLQuery(name = "ticket", description = "Get ticket by id")
    public Ticket fetchTicketById(UUID id) throws TicketNotFoundException {
        Stopwatch timer = Stopwatch.createStarted();
        var ticket = ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException(id, Ticket.class));
        log.info("[fetchTicketById] Method took: {}", timer.stop());
        return ticket;
    }

    @Override
    @GraphQLQuery(name = "tickets", description = "Get all tickets")
    public Iterable<Ticket> fetchAllTickets() {
        Stopwatch timer = Stopwatch.createStarted();
        var tickets = ticketRepository.findAll();
        log.info("[fetchAllTickets] Method took: {}", timer.stop());
        return tickets;
    }

    @Override
    @GraphQLQuery(name = "ticketsByState", description = "Get tickets by state")
    public Iterable<Ticket> fetchTicketByState(State state) {
        Stopwatch timer = Stopwatch.createStarted();
        var tickets = ticketRepository.findAllByState(state);
        log.info("[fetchTicketByState] Method took: {}", timer.stop());
        return tickets;
    }

    @Override
    @GraphQLQuery(name = "user", description = "User which created ticket")
    public User fetchUserForTicketId(@GraphQLContext Ticket ticket) {
        Stopwatch timer = Stopwatch.createStarted();
        var user = ticket.getUser();
        log.info("[fetchUserForTicketId] Method took: {}", timer.stop());
        return user;
    }
}

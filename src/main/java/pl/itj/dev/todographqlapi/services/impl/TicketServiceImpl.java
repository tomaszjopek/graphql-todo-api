package pl.itj.dev.todographqlapi.services.impl;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Service;
import pl.itj.dev.todographqlapi.exceptions.data.TicketNotFoundException;
import pl.itj.dev.todographqlapi.model.Ticket;
import pl.itj.dev.todographqlapi.repositories.TicketRepository;
import pl.itj.dev.todographqlapi.services.ifc.TicketService;

import java.util.UUID;

@Service
@GraphQLApi
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    @GraphQLQuery(name = "ticketById", description = "Get ticket by id")
    public Ticket fetchTicketById(UUID id) throws TicketNotFoundException {
        return ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException(id, Ticket.class));
    }

    @Override
    @GraphQLQuery(name = "tickets", description = "Get all tickets")
    public Iterable<Ticket> fetchAllTickets() {
        return ticketRepository.findAll();
    }
}

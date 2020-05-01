package pl.itj.dev.todographqlapi.services.impl;

import org.springframework.stereotype.Service;
import pl.itj.dev.todographqlapi.exceptions.data.TicketNotFoundException;
import pl.itj.dev.todographqlapi.model.Ticket;
import pl.itj.dev.todographqlapi.repositories.TicketRepository;
import pl.itj.dev.todographqlapi.services.ifc.TicketService;

import java.util.UUID;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket fetchTicketById(UUID id) throws TicketNotFoundException {
        return ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException(id, Ticket.class));
    }
}

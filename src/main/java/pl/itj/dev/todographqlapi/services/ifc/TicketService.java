package pl.itj.dev.todographqlapi.services.ifc;

import pl.itj.dev.todographqlapi.exceptions.data.TicketNotFoundException;
import pl.itj.dev.todographqlapi.model.Ticket;

import java.util.List;
import java.util.UUID;

public interface TicketService {

    Ticket fetchTicketById(UUID id) throws TicketNotFoundException;
    Iterable<Ticket> fetchAllTickets();

}

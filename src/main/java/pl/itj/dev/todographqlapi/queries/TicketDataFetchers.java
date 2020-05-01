package pl.itj.dev.todographqlapi.queries;

import graphql.schema.DataFetcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.itj.dev.todographqlapi.errors.DataNotFoundError;
import pl.itj.dev.todographqlapi.exceptions.data.TicketNotFoundException;
import pl.itj.dev.todographqlapi.model.Ticket;
import pl.itj.dev.todographqlapi.services.ifc.TicketService;

import java.util.UUID;

@Component
@Slf4j
public class TicketDataFetchers {

    private final TicketService ticketService;

    public TicketDataFetchers(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public DataFetcher<Ticket> getTicketById() {
        return environment -> {
            var uuid = UUID.fromString(environment.getArgument("id"));
            try {
                return ticketService.fetchTicketById(uuid);
            } catch (TicketNotFoundException e) {
                environment.getExecutionContext().addError(new DataNotFoundError(e));
                log.error(e.getMessage());
            }

            return null;
        };
    }
}

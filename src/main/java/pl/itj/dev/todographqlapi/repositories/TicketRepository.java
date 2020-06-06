package pl.itj.dev.todographqlapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.itj.dev.todographqlapi.model.State;
import pl.itj.dev.todographqlapi.model.Ticket;

import java.util.UUID;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, UUID> {

    Iterable<Ticket> findAllByState(State state);

}

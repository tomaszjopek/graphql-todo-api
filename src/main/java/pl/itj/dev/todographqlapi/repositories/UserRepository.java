package pl.itj.dev.todographqlapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.itj.dev.todographqlapi.model.Ticket;
import pl.itj.dev.todographqlapi.model.User;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}

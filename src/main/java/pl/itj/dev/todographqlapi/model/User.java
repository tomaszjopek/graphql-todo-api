package pl.itj.dev.todographqlapi.model;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "USERS")
@Data
@GraphQLType(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    @GraphQLQuery(name = "id", description = "User's id")
    private UUID id;

    @GraphQLQuery(name = "username", description = "User's username")
    private String username;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Ticket> tickets;

}

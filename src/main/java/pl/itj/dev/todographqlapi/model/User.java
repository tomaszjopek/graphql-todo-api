package pl.itj.dev.todographqlapi.model;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "USERS")
@Getter
@Setter
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
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 10)
    private Set<Ticket> tickets = new HashSet<>();
}

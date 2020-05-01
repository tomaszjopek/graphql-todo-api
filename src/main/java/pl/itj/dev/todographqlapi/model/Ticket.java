package pl.itj.dev.todographqlapi.model;

import io.leangen.graphql.annotations.GraphQLEnumValue;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "TICKETS")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    @GraphQLQuery(name = "id", description = "Ticket's id")
    private UUID id;

    @GraphQLQuery(name = "title", description = "Ticket's title")
    private String title;

    @GraphQLQuery(name = "description", description = "Ticket's description")
    private String description;

    @Enumerated(EnumType.STRING)
    @GraphQLQuery(name = "priority", description = "Ticket's priority")
    @GraphQLEnumValue
    private Priority priority;
}

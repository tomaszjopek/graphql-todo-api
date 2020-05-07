package pl.itj.dev.todographqlapi.model;

import io.leangen.graphql.annotations.GraphQLEnumValue;
import io.leangen.graphql.annotations.GraphQLId;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "TICKETS")
@GraphQLType(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    @GraphQLId
    private UUID id;

    @GraphQLQuery(name = "title", description = "Ticket's title")
    private String title;

    @GraphQLQuery(name = "description", description = "Ticket's description")
    private String description;

    @Enumerated(EnumType.STRING)
    @GraphQLQuery(name = "priority", description = "Ticket's priority")
    @GraphQLEnumValue
    private Priority priority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}

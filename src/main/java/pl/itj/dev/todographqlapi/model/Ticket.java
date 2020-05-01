package pl.itj.dev.todographqlapi.model;

import io.leangen.graphql.annotations.GraphQLComplexity;
import io.leangen.graphql.annotations.GraphQLEnumValue;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.GraphQLTypeResolver;
import io.leangen.graphql.annotations.types.GraphQLInterface;
import io.leangen.graphql.annotations.types.GraphQLType;
import lombok.Data;
import org.hibernate.annotations.Type;
import pl.itj.dev.todographqlapi.services.ifc.UserService;
import pl.itj.dev.todographqlapi.services.impl.UserServiceImpl;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "TICKETS")
@GraphQLType(name = "Ticket")
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

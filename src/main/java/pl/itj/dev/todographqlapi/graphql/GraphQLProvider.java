package pl.itj.dev.todographqlapi.graphql;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pl.itj.dev.todographqlapi.queries.TicketDataFetchers;

import javax.annotation.PostConstruct;
import java.net.URL;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Component
public class GraphQLProvider {

    private GraphQL graphQl;

    private final TicketDataFetchers ticketDataFetchers;

    public GraphQLProvider(TicketDataFetchers ticketDataFetchers) {
        this.ticketDataFetchers = ticketDataFetchers;
    }

    @Bean
    public GraphQL graphQL() {
        return graphQl;
    }

    @PostConstruct
    public void init() throws Exception {
        URL url = Resources.getResource("ticketql.graphqls");
        String sdl = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQl = GraphQL.newGraphQL(graphQLSchema).build();

    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("Query").dataFetcher("ticketById", ticketDataFetchers.getTicketById()))
                .build();
    }
}

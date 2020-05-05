package pl.itj.dev.todographqlapi.exceptions.base;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public abstract class DataNotFoundException extends Exception implements GraphQLError {

    public DataNotFoundException(UUID id, Class<?> clazz) {
        super(clazz.getSimpleName() + " could not be found for id= " + id);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return List.of();
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return Map.of("statusCode", HttpStatus.NOT_FOUND.value());
    }

}

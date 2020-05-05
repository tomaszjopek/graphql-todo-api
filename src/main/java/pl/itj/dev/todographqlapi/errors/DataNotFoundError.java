package pl.itj.dev.todographqlapi.errors;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import org.springframework.http.HttpStatus;
import pl.itj.dev.todographqlapi.exceptions.base.DataNotFoundException;

import java.util.List;
import java.util.Map;

public class DataNotFoundError implements GraphQLError {
    private DataNotFoundException exception;

    public DataNotFoundError(DataNotFoundException exception) {
        this.exception = exception;
    }

    @Override
    public String getMessage() {
        return exception.getMessage();
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

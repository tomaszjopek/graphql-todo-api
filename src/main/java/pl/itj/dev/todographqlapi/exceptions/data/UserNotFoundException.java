package pl.itj.dev.todographqlapi.exceptions.data;

import pl.itj.dev.todographqlapi.exceptions.base.DataNotFoundException;

import java.util.UUID;

public class UserNotFoundException extends DataNotFoundException {

    public UserNotFoundException(UUID id, Class<?> clazz) {
        super(id, clazz);
    }
}

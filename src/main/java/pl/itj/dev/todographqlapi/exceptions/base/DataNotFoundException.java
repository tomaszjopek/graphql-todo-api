package pl.itj.dev.todographqlapi.exceptions.base;

import java.util.UUID;

public abstract class DataNotFoundException extends Exception {

    private UUID id;
    private Class<?> clazz;

    public DataNotFoundException(UUID id, Class<?> clazz) {
        super(clazz.getSimpleName() + " could not be found for id= " + id);
        this.id = id;
        this.clazz = clazz;
    }
}

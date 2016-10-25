package by.pvt.dao;

import by.pvt.entity.Entity;

import java.util.List;

/**
 * Created by Dmitry on 10/25/2016.
 */
public abstract class AbstractDAO <K, T extends Entity> {
    public abstract List<T> getAll();
    public abstract T getEntityById(K id);
    public abstract boolean delete(K id);
    public abstract boolean delete(T entity);
    public abstract boolean create(T entity);
    public abstract T update(T entity);
}

package by.pvt.services;

import by.pvt.services.exception.ServiceException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dmitry on 10/23/2016.
 */
public interface IService<T, PK extends Serializable> {

    T get(PK id) throws ServiceException;

    List<T> getAll() throws ServiceException;

    void add(T object) throws ServiceException;

    void update(T object) throws ServiceException;

    void delete(T object) throws ServiceException;
}

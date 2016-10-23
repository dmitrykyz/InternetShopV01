package by.pvt.dao.impl;

import by.pvt.dao.IDao;
import by.pvt.dao.exception.DaoException;
import by.pvt.entity.Product;
import by.pvt.entity.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class DefaultDao<T, PK extends Serializable> implements IDao<T, PK> {

    public T get(PK id) throws DaoException {
        return null;
    }

    public List<T> getAll() throws DaoException {
        return null;
    }

    public void add(T object) throws DaoException {

    }

    public void update(T object) throws DaoException {

    }

    public void delete(T object) throws DaoException {

    }
}

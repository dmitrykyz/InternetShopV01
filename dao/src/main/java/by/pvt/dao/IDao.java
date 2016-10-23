package by.pvt.dao;

import by.pvt.dao.exception.DaoException;
import by.pvt.entity.Product;
import by.pvt.entity.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dmitry on 10/23/2016.
 */
public interface IDao<T, PK extends Serializable> {

    T get(PK id) throws DaoException;

    List<T> getAll() throws DaoException;

    void add(T object) throws DaoException;

    void update(T object) throws DaoException;

    void delete(T object) throws DaoException;

}

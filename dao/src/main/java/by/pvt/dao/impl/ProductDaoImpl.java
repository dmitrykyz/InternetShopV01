package by.pvt.dao.impl;

import by.pvt.dao.AbstractDAO;
import by.pvt.entity.Product;
import by.pvt.entity.User;

import java.util.List;

/**
 * Created by Dmitry on 10/25/2016.
 */
public class ProductDaoImpl extends AbstractDAO<Integer, Product> {

    public ProductDaoImpl() {
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product getEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(Product entity) {
        return false;
    }

    @Override
    public boolean create(Product entity) {
        return false;
    }

    @Override
    public Product update(Product entity) {
        return null;
    }
}

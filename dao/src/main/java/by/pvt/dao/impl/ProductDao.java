package by.pvt.dao.impl;

import by.pvt.dao.IDao;
import by.pvt.dao.exception.DaoException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class ProductDao<Product, String extends Serializable> implements IDao<Product, String> {

    private static final java.lang.String GET_PRODUCT_LIST_QUERY = "SELECT * FROM PRODUCT";
    private static final java.lang.String GET_PRODUCT_QUERY = "SELECT * FROM PRODUCT " +
            "WHERE PRODUCT_nameProduct = ?";
    private static final java.lang.String UPDATE_PRODUCT_QUERY = "UPDATE PRODUCT SET PRODUCT_price = ? WHERE PRODUCT_nameProduct = ?";
    private static final java.lang.String DELETE_PRODUCT_QUERY = "DELETE FROM PRODUCT WHERE PRODUCT_nameProduct = ?";
    private static final java.lang.String CREATE_PRODUCT_QUERY = "INSERT INTO PRODUCT VALUES(?,?,?,?)";

    public Product get(String nameProduct) throws DaoException {
        return null;
    }

    public List<Product> getAll() throws DaoException {
        return null;
    }

    public void add(Product object) throws DaoException {

    }

    public void update(Product object) throws DaoException {

    }

    public void delete(Product object) throws DaoException {

    }
}

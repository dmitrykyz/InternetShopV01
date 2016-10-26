package by.pvt.dao.impl;

import by.pvt.dao.AbstractDAO;
import by.pvt.entity.Product;
import by.pvt.pool.ConnectionPool;
import by.pvt.pool.exception.ConnectionPoolException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 10/25/2016.
 */
public class ProductDaoImpl extends AbstractDAO<Integer, Product> {

    private static Logger log = Logger.getLogger(ProductDaoImpl.class);

    public ProductDaoImpl() {
    }

    @Override
    public List<Product> getAll() {
        log.info("Get all Product in class ProductDaoImpl from db");
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Product> listProduct = new ArrayList<>();

        try {
            // opening database connection to MySQL server
            try {
                con = ConnectionPool.getInstance().takeConnection();
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
            // getting Statement object to execute query
            stmt = con.createStatement();
            // executing SELECT all query
            rs = stmt.executeQuery("SELECT * FROM product");

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setNameProduct(rs.getString("nameProduct"));
                product.setPrice(rs.getDouble("price"));
                product.setStatus(rs.getString("status"));
                listProduct.add(product);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return listProduct;
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

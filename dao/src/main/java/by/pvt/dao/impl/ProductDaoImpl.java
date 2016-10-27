package by.pvt.dao.impl;

import by.pvt.dao.AbstractDAO;
import by.pvt.entity.Product;
import by.pvt.pool.ConnectionPool;
import by.pvt.pool.exception.ConnectionPoolException;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 10/25/2016.
 */
public class ProductDaoImpl extends AbstractDAO<Integer, Product> {

    private static Logger log = Logger.getLogger(ProductDaoImpl.class);
    private static final String SELLECT_ALL_PRODUCT = "SELECT * FROM product";
    private static final String CREATE_PRODUCT = "INSERT INTO product(nameProduct, price, status) VALUES(?, ?, ?);";

    public ProductDaoImpl() {
    }

    @Override
    public List<Product> getAll() {
        log.info("Get all Product in class ProductDaoImpl from db");
        List<Product> listProduct = new ArrayList<>();

        // opening database connection to MySQL server
        // getting Statement object to execute query
        // executing SELECT all query
        try (Connection con = ConnectionPool.getInstance().takeConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(SELLECT_ALL_PRODUCT)) {

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setNameProduct(rs.getString("nameProduct"));
                product.setPrice(rs.getDouble("price"));
                product.setStatus(rs.getString("status"));
                listProduct.add(product);
            }

        } catch (SQLException | ConnectionPoolException e) {
            e.printStackTrace();
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
        log.info("Create new Product in class ProductDaoImpl and write in tabel Product");

        Product product = entity;
        String nameProduct = product.getNameProduct();
        Double price = product.getPrice();
        String status = product.getStatus();

        // opening database connection to MySQL server
        // and getting Statement object to execute query
        try (Connection con = ConnectionPool.getInstance().takeConnection();
             PreparedStatement stmt  = con.prepareStatement(CREATE_PRODUCT)) {

            stmt.setString(1, nameProduct);
            stmt.setDouble(2, price);
            stmt.setString(3, status);
            stmt.execute();

        } catch (SQLException | ConnectionPoolException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public Product update(Product entity) {
        return null;
    }
}

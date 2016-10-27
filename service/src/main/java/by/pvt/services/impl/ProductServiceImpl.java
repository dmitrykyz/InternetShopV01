package by.pvt.services.impl;

import by.pvt.dao.AbstractDAO;
import by.pvt.dao.DaoFactory;
import by.pvt.dao.DaoName;
import by.pvt.entity.Product;
import by.pvt.entity.User;
import by.pvt.services.AbstractService;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Dmitry on 10/25/2016.
 */
public class ProductServiceImpl extends AbstractService<Integer, Product> {

    private static Logger log = Logger.getLogger(ProductServiceImpl.class);

    public ProductServiceImpl() {
    }

    @Override
    public List<Product> getAll() {
        log.info("Get all Product from DB in class ProductServiceImpl using ");
        AbstractDAO<Integer, Product> productDao = DaoFactory.getInstance().getDao(DaoName.PRODUCT);
        return productDao.getAll();
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
        log.info("Create new Product in class ProductServiceImpl");
        AbstractDAO<Integer, Product> productDao = DaoFactory.getInstance().getDao(DaoName.PRODUCT);
        if (productDao.create(entity) == true) return true;
        else return false;
    }

    @Override
    public Product update(Product entity) {
        return null;
    }
}

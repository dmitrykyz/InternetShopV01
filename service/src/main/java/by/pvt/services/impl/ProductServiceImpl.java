package by.pvt.services.impl;

import by.pvt.entity.User;
import by.pvt.services.AbstractService;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Dmitry on 10/25/2016.
 */
public class ProductServiceImpl extends AbstractService<Integer, User> {

    private static Logger log = Logger.getLogger(ProductServiceImpl.class);

    public ProductServiceImpl() {
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(User entity) {
        return false;
    }

    @Override
    public boolean create(User entity) {
        return false;
    }

    @Override
    public User update(User entity) {
        return null;
    }
}

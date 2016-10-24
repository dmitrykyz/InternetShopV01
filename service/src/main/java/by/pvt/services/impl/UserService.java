package by.pvt.services.impl;

import by.pvt.dao.DaoFactory;
import by.pvt.dao.DaoName;
import by.pvt.dao.IDao;
import by.pvt.dao.exception.DaoException;
import by.pvt.entity.User;
import by.pvt.services.IService;
import by.pvt.services.exception.ServiceException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class UserService<User, String extends Serializable> implements IService<User, String> {

    public User get(String id) throws ServiceException {
        try {
            IDao<User, String> userDao = DaoFactory.getInstance().getDao(DaoName.USER);
            return userDao.get(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<User> getAll() throws ServiceException {
        return null;
    }

    public void add(User object) throws ServiceException {

    }

    public void update(User object) throws ServiceException {

    }

    public void delete(User object) throws ServiceException {

    }
}
